// Base URL API
const baseURL = "/api";

// Endpoint API
const endpoints = {
  category: "/category",
  author: "/author",
  publisher: "/publisher",
  book: "/book",
};

function populateDropdown(endpoint, dropdownSelector, selectedValue = null) {
  $.get(`${baseURL}${endpoint}`, function (response) {
    const dropdown = $(dropdownSelector);
    dropdown.empty(); // Clear existing options
    dropdown.append('<option value="">Pilih</option>'); // Default option

    if (Array.isArray(response.data)) {
      response.data.forEach((item) => {
        const isSelected = item.id == selectedValue ? "selected" : ""; // Check if the option should be selected
        dropdown.append(
          `<option value="${item.id}" ${isSelected}>${item.name}</option>`
        );
      });
    } else {
      console.error(`Unexpected data format for ${dropdownSelector}`, response);
    }
  });
}

function clearFormFields() {
  $("#id, #title, #synopsis, #stock, #publishedAt").val("");
}

function openForm() {
  clearFormFields();

  populateDropdown(endpoints.category, "#categoryId");
  populateDropdown(endpoints.author, "#authorId");
  populateDropdown(endpoints.publisher, "#publisherId");

  // Show the modal
  $("#modalForm").modal("show");
}

function saveBook() {
  const bookData = {
    title: $("#title").val(),
    category_id: $("#categoryId").val(),
    author_id: $("#authorId").val(),
    publisher_id: $("#publisherId").val(),
    synopsis: $("#synopsis").val(),
    stock: $("#stock").val(),
    publishedAt: $("#publishedAt").val(),
  };

  const method = $("#id").val() ? "PUT" : "POST";
  const url = $("#id").val()
    ? `${baseURL}${endpoints.book}/${$("#id").val()}`
    : `${baseURL}${endpoints.book}`;

  $.ajax({
    type: method,
    url: url,
    contentType: "application/json",
    data: JSON.stringify(bookData),
    success: function () {
      console.log("Book saved successfully");
      $("#modalForm").modal("hide");
      location.reload();
    },
    error: function (error) {
      console.error("Error saving book", error);
    },
  });
}

function editForm(bookId) {
  $.get(`${baseURL}${endpoints.book}/${bookId}`, function (response) {
    const book = response.data;

    // Pre-fill the form with the current book data
    $("#id").val(book.id);
    $("#title").val(book.title);
    $("#synopsis").val(book.synopsis);
    $("#stock").val(book.stock);
    $("#publishedAt").val(book.publishedAt);

    // Populate dropdowns and set selected value
    populateDropdown(endpoints.category, "#categoryId", book.category.id);
    populateDropdown(endpoints.author, "#authorId", book.author.id);
    populateDropdown(endpoints.publisher, "#publisherId", book.publisher.id);

    // Show the modal with the pre-filled data
    $("#modalForm").modal("show");
  });
}

function deleteBook(bookId) {
  if (confirm("Are you sure you want to delete this book?")) {
    $.ajax({
      type: "DELETE",
      url: `${baseURL}${endpoints.book}/${bookId}`,
      success: function () {
        console.log("Book deleted successfully");
        location.reload();
      },
      error: function (error) {
        console.error("Error deleting book", error);
      },
    });
  }
}

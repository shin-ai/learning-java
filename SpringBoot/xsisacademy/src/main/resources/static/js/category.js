function openForm() {
  $.ajax({
    type: "get",
    url: "/category/form",
    contentType: "html",
    success: function (categoryForm) {
      $("#myModal").modal("show");
      $(".modal-title").html("Category Form");
      $(".modal-body").html(categoryForm);
    },
  });
}

function editForm(id) {
  $.ajax({
    type: "get",
    url: `/category/edit/${id}`,
    contentType: "html",
    success: function (categoryForm) {
      $("#myModal").modal("show");
      $(".modal-title").html("Edit Category");
      $(".modal-body").html(categoryForm);
    },
  });
}

function deleteForm(id) {
  // Konfirmasi sebelum mengirim request AJAX
  if (confirm("Are you sure you want to delete?")) {
    $.ajax({
      type: "get",
      url: `/category/delete/${id}`,
      contentType: "html",
      success: function () {
        console.log("Category deleted successfully.");
        location.reload();
      },
      error: function (xhr, status, error) {
        console.error("Error:", error);
        alert("Error deleting category.");
      },
    });
  }
}

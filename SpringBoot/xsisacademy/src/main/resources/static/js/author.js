function openForm() {
  $.ajax({
    type: "get",
    url: "/author/form",
    contentType: "html",
    success: function (authorForm) {
      $("#myModal").modal("show");
      $(".modal-title").html("author Form");
      $(".modal-body").html(authorForm);
    },
  });
}

function editForm(id) {
  $.ajax({
    type: "get",
    url: `/author/edit/${id}`,
    contentType: "html",
    success: function (authorForm) {
      $("#myModal").modal("show");
      $(".modal-title").html("Edit author");
      $(".modal-body").html(authorForm);
    },
  });
}

function deleteForm(id) {
  // Konfirmasi sebelum mengirim request AJAX
  if (confirm("Are you sure you want to delete?")) {
    $.ajax({
      type: "get",
      url: `/author/delete/${id}`,
      contentType: "html",
      success: function () {
        console.log("author deleted successfully.");
        location.reload();
      },
      error: function (xhr, status, error) {
        console.error("Error:", error);
        alert("Error deleting author.");
      },
    });
  }
}

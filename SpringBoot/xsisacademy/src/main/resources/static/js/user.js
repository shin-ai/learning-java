function openForm() {
  $.ajax({
    type: "get",
    url: "/user/form",
    contentType: "html",
    success: function (userForm) {
      $("#myModal").modal("show");
      $(".modal-title").html("user Form");
      $(".modal-body").html(userForm);
    },
  });
}

function editForm(id) {
  $.ajax({
    type: "get",
    url: `/user/edit/${id}`,
    contentType: "html",
    success: function (userForm) {
      $("#myModal").modal("show");
      $(".modal-title").html("Edit user");
      $(".modal-body").html(userForm);
    },
  });
}

function deleteForm(id) {
  // Konfirmasi sebelum mengirim request AJAX
  if (confirm("Are you sure you want to delete?")) {
    $.ajax({
      type: "get",
      url: `/user/delete/${id}`,
      contentType: "html",
      success: function () {
        console.log("user deleted successfully.");
        location.reload();
      },
      error: function (xhr, status, error) {
        console.error("Error:", error);
        alert("Error deleting user.");
      },
    });
  }
}

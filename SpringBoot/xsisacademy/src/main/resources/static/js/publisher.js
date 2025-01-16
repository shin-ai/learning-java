function openForm() {
  $.ajax({
    type: "get",
    url: "/publisher/form",
    contentType: "html",
    success: function (publisherForm) {
      $("#myModal").modal("show");
      $(".modal-title").html("publisher Form");
      $(".modal-body").html(publisherForm);
    },
  });
}

function editForm(id) {
  $.ajax({
    type: "get",
    url: `/publisher/edit/${id}`,
    contentType: "html",
    success: function (publisherForm) {
      $("#myModal").modal("show");
      $(".modal-title").html("Edit publisher");
      $(".modal-body").html(publisherForm);
    },
  });
}

function deleteForm(id) {
  // Konfirmasi sebelum mengirim request AJAX
  if (confirm("Are you sure you want to delete?")) {
    $.ajax({
      type: "get",
      url: `/publisher/delete/${id}`,
      contentType: "html",
      success: function () {
        console.log("publisher deleted successfully.");
        location.reload();
      },
      error: function (xhr, status, error) {
        console.error("Error:", error);
        alert("Error deleting publisher.");
      },
    });
  }
}

const BASE_URL = "/api/category";

function openForm() {
  $("#id").val("");
  $("#name").val("");
  $("#myModal").modal("show");
}

// Mengisi form untuk edit data
function editForm(id) {
  $.ajax({
    type: "GET",
    url: `${BASE_URL}/${id}`,
    success: function (response) {
      let category = response.data;
      $("#id").val(category.id);
      $("#name").val(category.name);
      $("#myModal").modal("show");
      $(".modal-title").html("Category Form");
    },
  });
}

// Menyimpan (tambah/update) data
function save() {
  let id = $("#id").val();
  let name = $("#name").val();
  let method = id ? "PUT" : "POST";
  let url = id ? `${BASE_URL}/${id}` : BASE_URL;

  $.ajax({
    type: method,
    url: url,
    contentType: "application/json",
    data: JSON.stringify({ id, name }),
    success: function () {
      console.log("Success");
      $("#myModal").modal("hide");
      location.reload();
    },
  });
}

// Menghapus data
function deleteForm(id) {
  $.ajax({
    type: "DELETE",
    url: `${BASE_URL}/${id}`,
    success: function (response) {
      location.reload();
    },
  });
}

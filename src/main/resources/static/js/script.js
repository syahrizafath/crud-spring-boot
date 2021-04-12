$(function() {
    loadData();
});

function loadData() {
    $('#records_table > tr').remove();
    $.ajax({
        url: '/employee/',
        type: 'GET',
        success: function(response) {
            var trHTML = '';
            $.each(response, function(i, item) {
                trHTML += '<tr><td>' + item.id + '</td><td>' + item.nama + '</td><td>' + item.email + '</td><td>' + item.hp + '</td><td>' + "<button data-toggle='modal' data-target='#editModal' onclick='fillData(" + item.id + ")' class='btn btn-sm btn-success'><span class='fa fa-edit'></span> Edit</button> | <button onclick='remove(" + item.id + ")' class='btn btn-sm btn-danger'><span class='fa fa-trash'></span> Hapus</button>" + '</td></tr>';
            });
            $('#records_table').append(trHTML);
        }
    });
}

function clearInput() {
    $("input.form-control").val('');
}

function remove(id) {
    $.ajax({
        type: "DELETE",
        url: "/employee/" + id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data) {
            alert("Data has been deleted");
            loadData();
        },
        error: function(errMsg) {
            console.log(errMsg);
            alert("Terjadi Kesalahan!");
        }
    });
}

function fillData(id) {
    $.ajax({
        url: '/employee/' + id,
        type: 'GET',
        success: function(item) {
            $('#id-edit').val(id);
            $('#nama-edit').val(item.nama);
            $('#email-edit').val(item.email);
            $('#phone-edit').val(item.hp);
            $('#limit-edit').val(item.limit_reimbursement);
        }
    });
}

$("#form-add-user").submit(function(e) {

    $.ajax({
        url: '/employee/search/' + $("#nama").val(),
        type: 'GET',
        success: function(response) {
            if (response) {
                alert("Nama sudah ada!")
            } else {
                var dataJson = {
                    "nama": $("#nama").val(),
                    "email": $("#email").val(),
                    "hp": $("#phone").val(),
                    "limit_reimbursement": $("#limit").val()
                };

                $.ajax({
                    type: "POST",
                    url: "/employee/",
                    data: JSON.stringify(dataJson),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function(data) {
                        alert("Data has been saved");
                        clearInput();
                        loadData();
                    },
                    error: function(errMsg) {
                        alert("Terjadi Kesalahan!");
                    }
                });
            }
        },
        error: function(errMsg) {
            alert("Terjadi Kesalahan!");
        }
    });
    return false;
});

$("#form-edit-user").submit(function(e) {

    var dataJson = {
        "nama": $("#nama-edit").val(),
        "email": $("#email-edit").val(),
        "hp": $("#phone-edit").val(),
        "limit_reimbursement": $("#limit-edit").val()
    };

    $.ajax({
        type: "PUT",
        url: "/employee/" + $("#id-edit").val(),
        data: JSON.stringify(dataJson),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data) {
            alert("Data has been updated");
            clearInput();
            loadData();
            $("#closeEdit").trigger("click");
        },
        error: function(errMsg) {
            console.log(errMsg);
            alert("Terjadi Kesalahan!");
        }
    });
    return false;
});

$("#form-search-user").submit(function(e) {

    var dataJson = {
        "nama": $("#name-search").val(),
        "email": $("#email-search").val(),
        "hp": $("#phone-search").val(),
        "tanggal_masuk": $("#date-search").val()
    };

    $.ajax({
        type: "POST",
        url: "/employee/search",
        data: JSON.stringify(dataJson),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data) {
            var trHTML = '';
            $('#records_table > tr').remove();
            if (data.length === 0) {
                trHTML = "<tr><td class='text-center' colspan='5'>Data Tidak Ditemukan</td></tr>";
            } else {
                $.each(data, function(i, item) {
                    trHTML += '<tr><td>' + item.id + '</td><td>' + item.nama + '</td><td>' + item.email + '</td><td>' + item.hp + '</td><td>' + "<button data-toggle='modal' data-target='#editModal' onclick='fillData(" + item.id + ")' class='btn btn-sm btn-success'><span class='fa fa-edit'></span> Edit</button> | <button onclick='remove(" + item.id + ")' class='btn btn-sm btn-danger'><span class='fa fa-trash'></span> Hapus</button>" + '</td></tr>';
                });
            }
            $('#records_table').append(trHTML);
        },
        error: function(errMsg) {
            console.log(errMsg);
            alert("Terjadi Kesalahan!");
        }
    });
    return false;
});
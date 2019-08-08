$(document).ready(function () {
    alert("alert");
    $('.table .btn').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href');
        $.get(href, function (flight,status) {
            $('#idEdit').val(flight.id);
            $('#placeFromEdit').val(flight.placeFrom);
            $('#placeToEdit').val(flight.placeTo);
            $('#startDateEdit').val(flight.startDate);
            $('#endDateEdit').val(flight.endDate);
            $('#maxPlaceEdit').val(flight.maxPlace);
            $('#ticketPriceEdit').val(flight.ticketPrice);
        });
        $('#editModal').modal();
    });
});

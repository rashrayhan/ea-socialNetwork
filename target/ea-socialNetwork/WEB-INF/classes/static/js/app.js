$(document).ready(function() {
    $('#table_id').DataTable({
        stateSave: true
    });

    $(".commentToggle").click(function(){
        $(".cmtt-comments").toggle(500);
    });

} );

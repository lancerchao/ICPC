function resetFormAction(problem) {
    var action = pcsroot + "/api/submit?next=" + location.href;
    $("#submit-form>form").attr("action", action);
    $('#problem-select').val(problem);
}
$(function() {
    var anchor = location.hash;
    if (anchor && anchor.length > 0) {
        var letter = anchor.substring(1);
        $('#problem-tab-' + letter).tab('show');
        resetFormAction(letter);
    }
    $('.tab-toggle').on('click', function(event) {
        var tab = $(this);
        var problem = $(this).attr('data');
        location.hash = '#' + problem;
        resetFormAction(problem);
    });
});

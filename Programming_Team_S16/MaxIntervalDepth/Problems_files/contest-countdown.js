$(function() {
    function countdownEnd(element, end) {
        var now = new Date();
        element.empty();
        if (end < now) {
            element.append($("<div>").html("<p>You may still submit solutions, but the contest has ended.</p>"
                + "<p>View the <a href='" + pcsroot + "/scoreboard'>results</a></p>"));
        }
        else {
            var title = $("<h4>").text("Contest over in:");
            var text = $("<div>").html(countdown(end).toHTML());
            element.append(title);
            element.append(text);
            setTimeout(function() { countdownEnd(element, end); }, 1000);
        }
    }
    function countdownStart(element, start) {
        var now = new Date();
        if (start < now) {
            location.reload(true);
        }
        else {
            element.html(countdown(start).toHTML());
            setTimeout(function() { countdownStart(element, start); }, 1000);
        }
    }
    $.get(pcsroot + '/api/contest', function(data) {
        var start = new Date(data.data.start);
        var end = new Date(data.data.end);
        countdownEnd($("#contest-countdown-end"), end);
        if ($("#contest-countdown-start").length) {
            countdownStart($("#contest-countdown-start"), start);
        }
    });
});

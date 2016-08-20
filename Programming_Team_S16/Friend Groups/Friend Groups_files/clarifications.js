var clarificationsRead = [];
function markClarificationsAsRead(clarificationIDs) {
    var dict = {};
    clarificationsRead = getReadClarifications();
    for (var i = 0; i < clarificationsRead.length; i++) {
        dict[clarificationsRead[i]] = true;
    }
    for (var i = 0; i < clarificationIDs.length; i++) {
        if (dict[clarificationIDs[i]] !== true)  {
            clarificationsRead.push(clarificationIDs[i]);
        }
    }
    localStorage["clarificationsRead"] = JSON.stringify(clarificationsRead);
}
function getReadClarifications() {
    var storage = localStorage["clarificationsRead"];
    if (storage == null) {
        return [];
    }
    return $.parseJSON(localStorage["clarificationsRead"]);
}

$(function() {
    function countUnread(clarificationIDs) {
        var dict = {};
        for (var i = 0; i < clarificationsRead.length; i++) {
            dict[clarificationsRead[i]] = true;
        }
        var sum = 0;
        for (var i = 0; i < clarificationIDs.length; i++) {
            if (dict[clarificationIDs[i]] !== true) {
                sum++;
            }
        }
        return sum;
    }
    clarificationsRead = getReadClarifications();

    function pollImportantClarifications() {
        var url = pcsroot + "/api/clarifications/important";
        $.get(url, function(data) {
            data = data.data;
            var unread = countUnread(data.yours.concat(data.important));
            if (unread == 0) {
                unread = "";
            }
            $("#clarification-count").text(unread);
            setTimeout(pollImportantClarifications, 20*1000);
        });
    }
    setTimeout(pollImportantClarifications, 500);
});

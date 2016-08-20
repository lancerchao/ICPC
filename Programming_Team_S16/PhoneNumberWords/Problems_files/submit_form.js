$(function() {
    function endsWith(str, suffix) {
        return str.indexOf(suffix, str.length - suffix.length) !== -1;
    }
    
    $('#file-upload').on('change', function(event) {
        var filename = $(this).val();
        var language = $('#language-select');
        var extension_map = {
            '.java': 'java',
            '.c': 'c',
            '.cpp': 'c++',
            '.py': 'python'
        };
        for (var ext in extension_map) {
            if (endsWith(filename, ext)) {
                language.val(extension_map[ext]);
            }
        }
    });
});

(function ($) {

    $(document).ready(function () {
        $(".jsLogout").on("click", function () {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            $.ajax({
                url: 'logout',
                type: 'POST',
                data: token,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(header, token);
                },
                success: function (data) {
                    window.location = "/login";
                },
                error: function (data) {
                    console.log(data);
                }
            });
        });
    });

})(jQuery);

(function ($) {
    $(document).ready(function () {

        $(".jsAddComment").on("click", function () {
            $('.jsPopUpComment').bPopup({
                onClose: function () {
                    // setTimeout(function () {
                    //     location.reload();
                    // }, 3000);
                }
            });

        });

        $(".jsComment").on("click", function (event) {
            var $comment = $(".jsComment").closest("form");
            // var token = $("meta[name='_csrf']").attr("content");
            // var header = $("meta[name='_csrf_header']").attr("content");
            var $inputs = $comment.find(':input');

            var values = {};
            $inputs.each(function() {
                values[this.name] = $(this).val();
            });
            $.ajax({
                url: $comment.attr("action"),
                type: 'POST',
                data: JSON.stringify(values),
                contentType: "application/json",
                // beforeSend: function (xhr) {
                //     xhr.setRequestHeader(header, token);
                // },
                success: function (data) {
                    window.location.reload()
                },
                error: function (data) {
                    console.log(data);
                }
            });
            event.preventDefault();
        });

        $(".jsUp").on("click", function () {
            var id = $(".jsUp").closest(".post").attr("id");
            $.ajax({
                url: '/api/post/' + id + '/vote/',
                type: 'POST',
                data: { positive: true },
                success: function (data) {
                    setTimeout(function () {
                        location.reload();
                    }, 3000);
                }
            });
        });


        $(".jsDown").on("click", function () {
            var id = $(".jsDown").closest(".post").attr("id");
            $.ajax({
                url: '/api/post/' + id + '/vote/',
                type: 'POST',
                data: { positive: false },
                success: function (data) {
                    setTimeout(function () {
                        location.reload();
                    }, 3000);
                }
            });
        });
    });
})(jQuery);
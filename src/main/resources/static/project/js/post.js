(function ($) {
    $(document).ready(function () {

        $(".jsAddComment").on("click", function () {
            $('.jsPopUpComment').bPopup({
                                            onClose: function () {
                                            }
                                        });

        });

        $(".jsCreatePost").on("click", function () {
            $('.jsPopPost').bPopup({
                                       onClose: function () {
                                       }
                                   });

        });

        $(".jsComment").on("click", function (event) {
            var $comment = $(".jsComment").closest("form");
            // var token = $("meta[name='_csrf']").attr("content");
            // var header = $("meta[name='_csrf_header']").attr("content");
            var $inputs = $comment.find('textarea');
            var id = $comment.attr("data-id");
            var action = $comment.attr("action");
            action.replace("$$$", id);
            var values = {};
            $inputs.each(function () {
                values[this.name] = $(this).val();
            });
            $.ajax({
                       url: action,
                       type: 'POST',
                       data: JSON.stringify(values),
                       contentType: "application/json",
                       // beforeSend: function (xhr) {
                       //     xhr.setRequestHeader(header, token);
                       // },
                       success: function (data) {
                           setTimeout(function () {
                               location.reload();
                           }, 100);
                       },
                       error: function (data) {
                           console.log(data);
                       }
                   });
        });

        $(".jsPost").on("click", function (event) {
            var $post = $(".jsPost").closest("form");
            var $inputs = $post.find(':input:not(.btn), textarea');
            var values = {};
            $inputs.each(function () {
                values[this.name] = $(this).val();
            });

            values.tags = values.tags.split(",");
            $.ajax({
                       url: $post.attr("action"),
                       type: 'POST',
                       data: JSON.stringify(values),
                       contentType: "application/json",

                       success: function (data) {
                           setTimeout(function () {
                               location.reload();
                           }, 100);
                       },
                       error: function (data) {
                           console.log(data);
                       }
                   });
        });

        $(".jsUp").on("click", function () {
            var id = $(".jsUp").closest(".post").attr("id");
            $.ajax({
                       url: '/api/post/' + id + '/vote/',
                       type: 'POST',
                       data: {positive: true},
                       success: function (data) {
                           setTimeout(function () {
                               location.reload();
                           }, 100);
                       }
                   });
        });

        $(".jsDown").on("click", function () {
            var id = $(".jsDown").closest(".post").attr("id");
            $.ajax({
                       url: '/api/post/' + id + '/vote/',
                       type: 'POST',
                       data: {positive: false},
                       success: function (data) {
                           setTimeout(function () {
                               location.reload();
                           }, 100);
                       }
                   });
        });
    });
})(jQuery);
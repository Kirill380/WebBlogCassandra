(function ($) {
    $(document).ready(function () {

        $(".jsAddComment").on("click", function () {
            var template = '<div class="list_item">  ' +
                                '<div class="item">' +
                                    '<div class="item_body"> ' +
                                        '${body} – <span class="item_author-email">${email}</span> <span class="item_date">${time}</span> ' +
                                    '</div> ' +
                                '</div>' +
                            '</div>'
        })

    });
})(jQuery);
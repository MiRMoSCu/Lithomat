(function($){
    $.fn.entertab = function(options) {
        var defaults = {
            maxTabIndex: 100
        };
        options = $.extend({}, defaults, options);
        return this.filter('html').each(function(){
            var $this = $(this),
                $elms = $this.find("[tabindex]");

            $elms.each(function(){
                var $elm = $(this),
                    idx = parseInt($elm.attr("tabindex"));
                if (idx > options.maxTabIndex) {
                    return;
                }
                $elm.keydown(function(e){
                    if (e.which == 13 ) {
                        $elms.filter("[tabindex="+(idx+1)+"]").focus();
                        e.preventDefault();
                    }
                });
            });
        });
    };
})(jQuery);

$(function(){
    $("html").entertab();
});
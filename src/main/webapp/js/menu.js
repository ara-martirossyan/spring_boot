jQuery(document).ready(function () {

    jQuery('li:has("a.is-active")').addClass("active");


    if (jQuery(document).scrollTop() > jQuery('header').height() + 15) {
        jQuery('.navbar-brand').toggle();
        handleNavTop();
    }

    jQuery('#nav').affix({
        offset: {
            top: jQuery('header').height() + 15
        }
    });

    jQuery('#nav').on('affixed-top.bs.affix', function () {
        jQuery('.spacer').remove();
        jQuery('.navbar-brand').toggle();
    });


    jQuery('#nav').on('affix.bs.affix', function () {
        handleNavTop();

        jQuery("#nav").removeClass("preload");

        jQuery('.navbar-brand').toggle();

        var spacerWidth = jQuery('#nav').height()
        jQuery('<div class="spacer">&nbsp;</div>').insertAfter("header.blackgrad");
        jQuery('.spacer').height(spacerWidth + 5);
    });

    function handleNavTop() {
        if (jQuery('body').hasClass('toolbar-fixed')) {
            var height = jQuery("#toolbar-bar").height();
            if (jQuery('body').hasClass('toolbar-vertical')) {
                jQuery("#nav").css({top:height});
            }
            if (jQuery('body').hasClass('toolbar-horizontal')) {
                jQuery("#nav").css({top:height*2});
            }
        }
        else {
            jQuery("#nav").css({top:0});
        }
    }

});
$(document).on('ready', function(){
    /* 메인 배너 슬라이드*/
    $('.banner-slide').slick({
        centerMode: true,
        dots: true,
        centerPadding: '20px',
        slidesToShow: 3,
        autoplay:true,
        autoplaySpeed: 3200,
        variableWidth: true,
        infinite:true,
        arrows: false
    });

    /*색션 2 슬라이드*/
    $('.best_slide').slick({
        dots: true,
        slidesToShow: 1,
        autoplay:true,
        autoplaySpeed: 4000,
        variableWidth: true,
        infinite:true,
        arrows: false
    });

});
(function($){
    $('.modal').hide();
    $('.modal2').hide();
    $('#encadreConnection').hide();
    $('#miseInput').val("");

    $('#validerParis').on('click', function () {
        $('.shadow, .modal').show();
    });

    $('.shadow').on('click', function () {
        $('.shadow, .modal, .modal2').hide();
        $('#miseInput').val("");
    });

    $('.vic a').on('click', function(){
        console.log("valeur de la cote : " + $(this).html());
        $('#cote').html($(this).html());
        var tempURL = $(this).parent().parent().find(".infoParis p:nth-child(2)");
        console.log("valeur du match : " + $(tempURL).html()/* $(' .infoParis p:nth-child(2)').html()*/);
        $('#selectedMatch').html($(tempURL).html());
        $('.shadow, .modal2').show();
    });

    $('#miseInput').on('input', function(){calculGain()})

    var login = "";
    var password = "";

    $('#validerParis').on('click', function () {
        if(!userCoo){
            $('#parisValide').addClass('colorRed').html('Vous devez vous connecter pour parier !')
        }
        else{
            $('#parisValide').addClass('colorRed').html('Votre paris a bien été pris en compte')
        }
    })

})(jQuery);

function calculGain(){
    var gains = Number($('#cote').html()) * Number($('#miseInput').val());
    $('#gainPoentiels').html(gains.toFixed(2));
}
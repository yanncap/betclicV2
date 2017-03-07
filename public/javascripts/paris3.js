(function($){

    function init(){
        $('#miseInput').val("");
    }

    $('#validerParis').on('click', function (){displayParisSelected()});

    $('.shadow').on('click', function () {
        $('.shadow, .modal2').hide();
        $('#miseInput').val("");
    });

    $('.vic a').on('click', function(){
        console.log("valeur de la cote : " + $(this).html());
        $('#cote').html($(this).html());
        //Récupération de la team A et B
        var teamA = $(this).parents('.ligneParis').find(".teamA");
        var teamB = $(this).parents('.ligneParis').find(".teamB");

        console.log("Team A : " + teamA.html());
        console.log("Team B : " + teamB.html());

        //concatenation des deux tem pour présenter le match
        var findMatchDescription = teamA.html() + ' - ' + teamB.html()

        console.log("valeur du match : " + findMatchDescription/* $(' .infoParis p:nth-child(2)').html()*/);
        $('#selectedMatch').html("Match : " + findMatchDescription);

        if($(this).parent().hasClass("vicA")){
            $('#result').html(teamA.html());
        }else if($(this).parent().hasClass("vicB")){
            $('#result').html(teamB.html());
        }
        else{
            $('#result').html("Nul");
        }

        $('.shadow, .modal2').show();

    });

    $('#miseInput').on('input', function(){calculGain()});


    $('#validerParis').on('click', function () {
        if(!userCoo){
            $('#parisValide').addClass('colorInformation').html('Vous devez vous connecter pour parier !')
        }
        else{
            $('#parisValide').addClass('colorInformation').html('Votre paris a bien été pris en compte')
        }
    })

})(jQuery);



function calculGain(){
    var gains = Number($('#cote').html()) * Number($('#miseInput').val());
    $('#gainPoentiels').html(gains.toFixed(2));
}

function displayParisSelected(){
    $('.shadow, .modal').show();
}
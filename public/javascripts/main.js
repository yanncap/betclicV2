var boolDico = false;
var tabLien = ["foot1.jpg","foot2.jpg","foot3.jpg","foot4.jpg","tennis.jpg"];
var tabTitre1 = ["Football, Ligue 1","Football, Ligue 2","Football, Ligue 1","Football, Ligue 1","Tennis"];
var tabTitre2 = ["Paris SG - Lille","Strasbourg - Lyon", "Marseille - Barcelone", "Real M. - St Etienne","Nadal - Federer"];
var interval;
var target = 1;
var NbrItemCarou = 5;
var userCoo = false;

$(function(){
    $(".menuMBouton").on("click", function(){lateral()});
    $(".shadow").on("click", function(){lateralFin()});
    $(".btnDicoMob").on("click", function(){affiDico()});

    $("#okS").on("click", function(){fausseConnection(1)});
    $("#okM").on("click", function(){fausseConnection(2)});
    initCarou();
    interval = setInterval(travelingCarou,3000);
    $(".caroussel").hover(stopCarou , playCarou);
});

function lateral(){
    $(".shadow").show();
    $(".shadow").css('z-index', 1);
    $(".menuLateral").show();
    $(".menuLateral").css('z-index', 2);
}

function lateralFin(){
    $(".shadow").hide();
    $(".menuLateral").hide();
}

function affiDico(){
    if(boolDico == false){
        $(".btnDicoMob i").html("vertical_align_top");
        $(".dico").show();
        boolDico = true;
    }else{
        boolDico = false;
        $(".dico").hide();
        $(".btnDicoMob i").html("vertical_align_bottom")
    }
}

function fausseConnection(choix){
    var tempPseudo,tempPassword;
    if(choix ==1){
        tempPseudo = $("#pseudoS").val();
        tempPassword = $("#passwordS").val();
    }else{
        tempPseudo = $("#pseudoM").val();
        tempPassword = $("#passwordM").val();
    }
    if (tempPseudo != "" && tempPassword != ""){
        userCoo = true;
        $("#titreCoo").html("Connecté !")
        $(".liForm").html("<p>Bienvenue : "+tempPseudo+"</p><p>Votre Solde est de: 20.50€</p><a href='html/comptePage.html'>Compte</a> / <a href=''>Se Déconnecter</a>");
    }
}

function initCarou(){
    $(".fondCarou").css("width", NbrItemCarou*700+"px");
    for (var i=0 ; i<NbrItemCarou ; i++){
        $(".fondCarou").append("<div class='itemCarou' id='itemCarou"+i+"'><img src='images/"+ tabLien[i] +"'></div>");
        $('#itemCarou'+i).append("<a href='html/paris.html'><div class='lienCarou'><h6 class='titreItem1'>"+ tabTitre1[i] +"</h6><h5 class='titreItem2'>"+ tabTitre2[i] +"</h5></div></a>");
    }
}

function travelingCarou(){
    if(target < NbrItemCarou){
        $(".fondCarou").animate({left: "-=" + 700 + "px"}, 500);
        target++;
    }else{
        reinitCarou();
    }
}

function reinitCarou(){
    $(".fondCarou").animate({left: "0px"}, 800);
    target = 1;
}

function stopCarou(){
    clearInterval(interval);
}

function playCarou(){
    interval = setInterval(travelingCarou,3000);
}
/*function sizing(){
 var taillePage = $("body").innerWidth();
 console.log(taillePage);
 }*/


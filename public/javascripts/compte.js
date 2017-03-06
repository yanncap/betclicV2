/**
 * Created by formation on 07/02/17.
 */

(function ($) {
    $(function(){

      validerChamps();


        $('#modif-button').on('click',function () {

                $('.statut').attr("disabled",false);
                $('#valid-button,#annuler-button').css("display","inline-block");

        })

        $('#valid-button').on('click',function () {

            $('.statut').attr("disabled",true);
            $(this).css("display","none");
            $('#annuler-button').css("display","none");
            validerChamps();

        })
        $('#annuler-button').on('click',function () {

            $('.statut').attr("disabled",true);
            $(this).css("display","none");
            $('#valid-button').css("display","none");
            validerChamps();

        })
    });

    function validerChamps(){
        if ($('#nomPorteur').val()==""||$('#numCarte').val()==""||$('#codeSecurite').val()==""||$('#experation').val()==""){
            $('.aletre_carte').css("display","inline-block");
        }
        else{
            $('.aletre_carte').css("display","none");
        }
    }


})(jQuery);

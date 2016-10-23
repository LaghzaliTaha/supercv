/**
 * Created by alibousenna on 24/03/2016.
 */
app.controller('themeController'  , function($scope,RestEntry , $rootScope,userInfo,$compile,$window,$localStorage) {
    //=====================================chargement des elements du CV===============================//


    var currentUser=JSON.parse(userInfo.getUserInfo());
    var currentCV=$window.sessionStorage["ID-CV"];
    $rootScope.theme="styles.css";
    RestEntry.getService("http://localhost:8089/CV/find/Experiences/"+currentUser.id+"/"+currentCV+"").then(function(d){
        $scope.experienceSets= d;
    });
    RestEntry.getService("http://localhost:8089/CV/find/Formations/"+currentUser.id+"/"+currentCV+"").then(function(d){
        $scope.formationSets= d;
    });
    RestEntry.getService("http://localhost:8089/CV/find/Loisirs/"+currentUser.id+"/"+currentCV+"").then(function(d){
        $scope.SkillSets= d;
    });
    RestEntry.getService("http://localhost:8089/CV/find/Liens/"+currentUser.id+"/"+currentCV+"").then(function(d){
        $scope.lienSets= d;
    });

    RestEntry.getService("http://localhost:8089/CV/find/InformationPersonnel/"+currentUser.id+"/"+currentCV+"").then(function(d){
        $scope.infoPersonnel=d;
    });
    RestEntry.getService("http://localhost:8089/CV/find/infoCV/"+currentCV+"").then(function(d){
        $scope.infoCV=d;
    });
    RestEntry.getService("http://localhost:8089/CV/find/Languages/"+currentUser.id+"/"+currentCV+"").then(function(d){
        $scope.languageSets=d;
        $('.rating-input').rating({
            min: 0,
            max: 5,
            step: 1,
            size: 'xs',
            animate:true
        });


    });

    RestEntry.getService("http://localhost:8089/CV/find/Competences/"+currentUser.id+"/"+currentCV+"").then(function(d){
        $scope.competenceSets=d;
    });
    $scope.vm={options:['#42A8C0','#4CAC9D', '#5BB66F', '#A15277', '#FDA246', '#4B6A78'],
            color:'#42A8C0'};
    $scope.changeColor = function (option) {
        if($scope.vm.color != option) {
            $scope.vm.color = option;
            switch(option) {
                case '#42A8C0':
                    $scope.theme="styles.css";
                    break;
                case '#4CAC9D':
                    $scope.theme="styles-2.css";
                    break;
                case '#5BB66F':
                    $scope.theme="styles-3.css";
                    break;
                case '#A15277':
                    $scope.theme="styles-4.css";
                    break;
                case '#FDA246':
                    $scope.theme="styles-5.css";
                    break;
                case '#4B6A78':
                    $scope.theme="styles-6.css";
                    break;

            }
        }
    };
    //=============================================affichage outil d'edition=============================================//
    $scope.affichageOutilSkill=true;
    $scope.affichageOutilCompetence=true;
    $scope.affichageOutilFormation=true;
    $scope.affichageOutilExperience=true;
    $scope.affichageOutilLien=true;
    $scope.affichageOutilLangue=true;
    $scope.affichageOutilContact=true;
    $scope.afficherOutil=function(event){
        if(event=='skill')
            $scope.affichageOutilSkill=false;
        if(event=='competence')
            $scope.affichageOutilCompetence=false;
        if(event=='formation')
            $scope.affichageOutilFormation=false;
        if(event=='experience')
            $scope.affichageOutilExperience=false;
        if(event=='lien')
            $scope.affichageOutilLien=false;
        if(event=='contact')
            $scope.affichageOutilContact=false;
        if(event=='langue')
            $scope.affichageOutilLangue=false;
    }
    $scope.cacherOutil=function(event){
        if(event=='skill')
            $scope.affichageOutilSkill=true;
        if(event=='competence')
            $scope.affichageOutilCompetence=true;
        if(event=='formation')
            $scope.affichageOutilFormation=true;
        if(event=='experience')
            $scope.affichageOutilExperience=true;
        if(event=='lien')
            $scope.affichageOutilLien=true;
        if(event=='contact')
            $scope.affichageOutilContact=true;
        if(event=='langue')
            $scope.affichageOutilLangue=true;

    }


    //====================================================personnaliser cv================================================//
        //ajout par click +

    var compt=0;
    var blocAdd=false;
    function addItem() {
        compt++;
        var item=" <li ><input ></li>";
        $("#listItem").append(item);
        $('<button/>', {
            "class" :"icon-trash delete ",
            click: function(){
                var confirmation = confirm('Delete this item?');
                if(confirmation) {
                    $(this).closest('li').remove();
                    compt--;

                }
            }
        }).appendTo($("#listItem li:nth-child("+(compt+1)+")"));


    }
        //ajout par selection

    function addselect(){

           $('#blocCompetence'+compt).find('#competenceAded').off();
        compt++;
           var newitem= '<div class="col-md-3 col-xs-12  " style="bottom: 0px;" id="blocCompetence'+compt+'" >'+
               '<div class="competence-item" >'+
               '<div style="margin-left: 20px"><select id="competenceAded'+compt+'">'+
               '<option value="-1">---</option>'+
               '</select></div>'+
               '<div id="progressBar'+compt+'" class="meter" style="margin-left: 15px"><span  class="'+$scope.app.themeCV.titleBloc+'" style="width:50%"></span></div>'+
               '</div>'+
               '</div>';
        $("#elementAjouter").append(newitem);
        $("#competenceAded"+compt).tinyselect({ dataUrl: "competence.json"  });
           $('#competenceAded'+compt).on('change',addselect);
        $('#progressBar'+compt).click( function (e) {
            var position = $(this).offset();
            var clickValue=(e.pageX-position.left)*0.90
            $(this).find('span').css('width',clickValue+'%');

        });
        $('#progressBar'+compt).mousemove(function (e) {
            var position = $(this).offset();
            var clickValue=(e.pageX-position.left)*0.90
            $(this).find('span').css('width',clickValue+'%');

        });




    }

    //=================================================sauvegarde de l'element========================================//
        var logo=null;


    $scope.saveElement =function(nature){
        if(blocAdd==true)
        {
            if(nature==undefined)
            {  var contact=$('#selectLien option:selected').attr('contact');
                if(contact=='null')
                     contact=null

                var itemLien= {
                    "contact": contact,
                    "url": $('#inputLien').val(),
                    "logo": $('#selectLien option:selected').val()
                }
                if(  itemLien.url.length==0 )
                {
                    Notifier.error("les champs en rouge sont obligatoires");
                    $("#inputLien").css("border", "solid 1px red");
                    $("#inputLien").css("box-shadow", "0 0 5px 1px #e4b9b9");
                }
                else {
                    $("#elementAjouter").addClass('loding');
                    $("#elementAjouter").append(
                        "<div class='spinner'>" +
                        "<div class='rect1'></div> " +
                        "<div class='rect2'></div> " +
                        "<div class='rect3'></div> " +
                        "<div class='rect4'></div> " +
                        "<div class='rect5'></div> </div>");
                    RestEntry.postService("http://localhost:8089/lien/"+currentCV+"/add",itemLien).then(function(d){
                        $scope.lienSets.push(d);
                        $('#addLien i').removeClass("fa-reply").addClass("fa-plus");
                        $("#elementAjouter").remove();
                        Notifier.success('Operation enregistrer');
                        blocAdd = false;
                    },function(e){
                        $("#elementAjouter").remove();
                        Notifier.error("verifier que vous etes connectez à votre connection internet");
                    });
                }

            }

            if(nature=='skills')
            {
                var itemSkill = {
                    "typeLoisr": $("#input1").val(),
                    "detailles": []
                };


                for (var i = 0; i <= compt; i++) {
                    $("#listItem li:nth-child(" + (i + 1) + ")").attr('id', "item" + i);
                    $("#item" + i + " input").attr('id', "itemInput" + i);
                    itemSkill.detailles[i] = $("#itemInput" + i).val();

                }
                //pour ne pas afficher une li si l'utilisateur n'a pas ajouter de specialité
                if(itemSkill.detailles[0].length==0)
                {
                    itemSkill.detailles=[];
                }
                if(  itemSkill.typeLoisr.length==0 )
                {
                    Notifier.error("les champs en rouge sont obligatoires");
                    $("#input1").css("border", "solid 1px red");
                    $("#input1").css("box-shadow", "0 0 5px 1px #e4b9b9");
                }
                else{
                    $("#elementAjouter").addClass('loding');
                    $("#elementAjouter").append(
                        "<div class='spinner'>" +
                        "<div class='rect1'></div> " +
                        "<div class='rect2'></div> " +
                        "<div class='rect3'></div> " +
                        "<div class='rect4'></div> " +
                        "<div class='rect5'></div> </div>");
                    RestEntry.postService("http://localhost:8089/loisir/"+currentCV+"/add",itemSkill).then(function(d){
                        $scope.SkillSets.push(d);
                        $(".buttonAdd a i").removeClass("fa-reply");
                        $(".buttonAdd a span").text("Enregister Formation");
                        $(".buttonAdd a i").addClass(" fa-plus");
                        $("#elementAjouter").remove();
                        Notifier.success('Operation enregistrer');
                        compt = 0;
                        blocAdd = false;
                    },function(e){
                        $("#elementAjouter").remove();
                        Notifier.error("verifier que vous etes connectez à votre connection internet");
                    });}


            }
            if(nature=='formations')
                 {
            var itemFormation = {
                "nomFormation": $("#input1").val(),
                "etablissement": $("#input2").val(),
                "dateDebut": $("#input3").val(),
                "dateFin": $("#input4").val(),
                "specialities": []
            };


            for (var i = 0; i <= compt; i++) {
                $("#listItem li:nth-child(" + (i + 1) + ")").attr('id', "item" + i);
                $("#item" + i + " input").attr('id', "itemInput" + i);
                itemFormation.specialities[i] = $("#itemInput" + i).val();

            }
            //pour ne pas afficher une li si l'utilisateur n'a pas ajouter de specialité
            if(itemFormation.specialities[0].length==0)
                {
                    itemFormation.specialities=[];
                }
          if(itemFormation.dateDebut.length==0 || itemFormation.dateFin.length==0 || itemFormation.nomFormation.length==0 || itemFormation.etablissement.length==0)
          {
              Notifier.error("les champs en rouge sont obligatoires");
              $("#input1,#input2,#input3,#input4").css("border", "solid 1px red");
              $("#input1,#input2,#input3,#input4").css("box-shadow", "0 0 5px 1px #e4b9b9");
          }
            else{
              $("#elementAjouter").addClass('loding');
              $("#elementAjouter").append(
                  "<div class='spinner'>" +
                  "<div class='rect1'></div> " +
                  "<div class='rect2'></div> " +
                  "<div class='rect3'></div> " +
                  "<div class='rect4'></div> " +
                  "<div class='rect5'></div> </div>");
            RestEntry.postService("http://localhost:8089/formation/"+currentCV+"/add",itemFormation).then(function(d){
                $scope.formationSets.push(d);
                $(".buttonAdd a i").removeClass("fa-reply");
                $(".buttonAdd a span").text("Enregister Formation");
                $(".buttonAdd a i").addClass(" fa-plus");
                $("#elementAjouter").remove();
                Notifier.success('Operation enregistrer');


                compt = 0;
                blocAdd = false;
            },function(e){
                $("#elementAjouter").remove();
                Notifier.error("verifier que vous etes connectez à votre connection internet");
            });}


        }
            if(nature=='competences')
            {
                var itemCompetence = {
                "domaineCompetence": $("#input1").val(),
                "itemCompetences": []
            };
            for (var i=0;i<compt;i++){
                var x=$('#progressBar'+i).find('span').css('width').replace('px','');
                if(x>100)
                x=100
                if(x<0)
                x=0
                itemCompetence.itemCompetences[i]={
                    "logoItemCompetence":  $('#competenceAded'+i).val(),
                    "titreItemCompetence":  $('#competenceAded'+i+' option:selected').text(),
                    "levelItemCompetence":x,

                }
            }
                if(itemCompetence.domaineCompetence.length==0||itemCompetence.itemCompetences.length==0)
                {
                    Notifier.error("les champs en rouge sont obligatoires");
                    $('#blocCompetence0').find('#competenceAded').css("border", "solid 1px red");
                    $('#blocCompetence0').find('#competenceAded').css("box-shadow", "0 0 5px 1px #e4b9b9");
                    $('#blocCompetence0').find('#levelAded').css("border", "solid 1px red");
                    $('#blocCompetence0').find('#levelAded').css("box-shadow", "0 0 5px 1px #e4b9b9");
                    $("#input1").css("border", "solid 1px red");
                    $("#input1").css("box-shadow", "0 0 5px 1px #e4b9b9");
                }
                else {
                    $("#elementAjouter").addClass('loding');
                    $("#elementAjouter").append('<div  style="position: relative;z-index: 99999;right: 150px;top: 10px" ><i class="fa  fa-3x  fa-spinner fa-spin"></i></div>');
                    RestEntry.postService("http://localhost:8089/competence/"+currentCV+"/add",itemCompetence).then(function(d){
                        $scope.competenceSets.push(d);
                        $(".buttonAdd a i").removeClass("fa-reply");
                        $(".buttonAdd a span").text("Ajouter Formation");
                        $(".buttonAdd a i").addClass(" fa-plus");
                        $("#elementAjouter").remove();
                        Notifier.success('Operation enregistrer');


                        compt = 0;
                        blocAdd = false;
                    },function(e){
                        $("#elementAjouter").remove();
                        Notifier.error("verifier que vous etes connectez à votre connection internet");
                    });

                }

            }
            if(nature=='experiences')
            {

                var itemExperience = {
                    "poste": $("#input1").val(),
                    "entreprise": $("#input2").val(),
                    "typeContrat": $("#input3").val(),
                    "dateDebut":$("#input4").val(),
                    "dateFin": $("#input5").val(),
                "ville": $("#input6").val(),
                "pays": $("#input7").val(),
                    "logo":null,
                    "mission": []
                };
                for (var i = 0; i <= compt; i++) {
                    $("#listItem li:nth-child(" + (i + 1) + ")").attr('id', "item" + i);
                    $("#item" + i + " input").attr('id', "itemInput" + i);
                    itemExperience.mission[i] = $("#itemInput" + i).val();

                }
                //pour ne pas afficher une li si l'utilisateur n'a pas ajouter de specialité
                if(itemExperience.mission[0].length==0)
                {
                    itemExperience.mission=[];
                }
                if(itemExperience.dateDebut.length==0 || itemExperience.dateFin.length==0 || itemExperience.poste.length==0 || itemExperience.pays.length==0|| itemExperience.ville.length==0|| itemExperience.typeContrat.length==0)
                {
                    Notifier.error("les champs en rouge sont obligatoires");
                    $("#input1,#input2,#input3,#input4,#input5,#input6,#input7").css("border", "solid 1px red");
                    $("#input1,#input2,#input3,#input4,#input5,#input6,#input7").css("box-shadow", "0 0 5px 1px #e4b9b9");
                }
                else{
                    $("#elementAjouter").addClass('loding');
                    $("#elementAjouter").append(
                        "<div class='spinner'>" +
                        "<div class='rect1'></div> " +
                        "<div class='rect2'></div> " +
                        "<div class='rect3'></div> " +
                        "<div class='rect4'></div> " +
                        "<div class='rect5'></div> </div>");



                    if(logo!=null) //enregistrement de l'image au serveur si l'utilisateur la uploader
                    {

                        var xhr=new XMLHttpRequest();
                        xhr.addEventListener('load',function(e){
                            var json=JSON.parse(e.target.responseText);
                            if(json.error){
                                Notifier.error(json.error);
                                return false
                            }
                            else {
                                itemExperience.logo=json.name;
                                RestEntry.postService("http://localhost:8089/experience/"+currentCV+"/add",itemExperience).then(function(d){
                                    $scope.experienceSets.push(d);
                                    $(".buttonAdd a i").removeClass("fa-reply");
                                    $(".buttonAdd a span").text("Enregister Formation");
                                    $(".buttonAdd a i").addClass(" fa-plus");
                                    $("#elementAjouter").remove();
                                    Notifier.success('Operation enregistrer');
                                    compt = 0;
                                    blocAdd = false;
                                },function(e){
                                    $("#elementAjouter").remove();
                                    Notifier.error("verifier que vous etes connectez à votre connection internet");
                                });

                            }
                        },false);
                        xhr.open('post', 'php/upload_logo.php',true);
                        xhr.setRequestHeader('content-type','multipart/form-data');
                        xhr.setRequestHeader('x-file-type',logo.type);
                        xhr.setRequestHeader('x-file-size',logo.size);
                        xhr.setRequestHeader('x-file-name',logo.name);
                        xhr.send(logo);
                    }
                    else{
                    RestEntry.postService("http://localhost:8089/experience/"+currentCV+"/add",itemExperience).then(function(d)
                    {
                        $scope.experienceSets.push(d);
                        $(".buttonAdd a i").removeClass("fa-reply");
                        $(".buttonAdd a span").text("Enregister Formation");
                        $(".buttonAdd a i").addClass(" fa-plus");
                        $("#elementAjouter").remove();
                        Notifier.success('Operation enregistrer');
                        compt = 0;
                        blocAdd = false;
                    },function(e){
                        $("#elementAjouter").remove();
                        Notifier.error("verifier que vous etes connectez à votre connection internet");
                    });}

                }


            }
        }
        else{
            Notifier.warning("vous n'avez rien a ajouter");
        }

    };
    $scope.saveLangue=function(){

          var logo=$('#selectLien option:selected').attr('logo');


            var language= {
                "logo": logo,
                "nomLanguage": $('#selectLien option:selected').val(),
                "level":0
            }

            if(  logo =='langue')
            {
                Notifier.error("Vous devez choisir une langue");

            }
            else {
                $("#elementAjouter").addClass('loding');
                $("#elementAjouter").append(
                    "<div class='spinner'>" +
                    "<div class='rect1'></div> " +
                    "<div class='rect2'></div> " +
                    "<div class='rect3'></div> " +
                    "<div class='rect4'></div> " +
                    "<div class='rect5'></div> </div>");

                RestEntry.postService("http://localhost:8089/language/"+currentCV+"/add",language).then(function(d){
                    $scope.languageSets.push(d);
                    $scope.$apply();
                    $('.rating-input').rating({
                        min: 0,
                        max: 5,
                        step: 1,
                        size: 'xs',
                        animate:true
                    });

                    $('#addLien i').removeClass("fa-reply").addClass("fa-plus");
                    $("#elementAjouter").remove();
                    Notifier.success('Operation enregistrer');

                },function(e){
                    $("#elementAjouter").remove();
                    Notifier.error("verifier que vous etes connectez à votre connection internet");
                });
            }

        }

    //=================================================ajout de l'element===========================================//



    $scope.addElement= function(nature){

        if(blocAdd==false)
        {
            var bloc;
            $('.addLien i').removeClass("fa-plus").addClass(" fa-reply");
            $(".buttonAdd a i").removeClass("fa-plus");
            $(".buttonAdd a span").text("Annuler l'ajout");
            $(".buttonAdd a i").addClass(" fa-reply");

            if(nature=='formations'){
            bloc="<div id='elementAjouter' >"+
                "<span class='title-area {{app.themeCV.titleItem}}' >" +
                "<input type='text' id='input1'  >" +
                "</span>" +
                " <p  class='describe' style='margin-top: 3px'>"
                + "<input type='text' id='input2' >"
                + "<i class='fa fa-circle iconList'></i>" +
                "<input type='date' id='input3' style='height: 20px'>/<input type='date' id='input4' >"

                + "</p><ul class='listAdd'  id='listItem'> <li ><input ><button class='add icon-plus' > </button> </li></ul>"
                +"</div>";}
            if(nature=='skills'){
                bloc="<div id='elementAjouter' >"+
                "<span class='title-area {{app.themeCV.titleItem}}' >" +
                "<input type='text' id='input1'>" +
                "</span>" +
                "<ul class='listAdd'  id='listItem'> <li ><input ><button class='add icon-plus' > </button> </li></ul>"
                +"</div>";}
            if(nature=='experiences'){
                bloc="<div id='elementAjouter' >"+
                    "<span class='title-area {{app.themeCV.titleItem}}' >" +
                    "<input type='text' id='input1' placeholder='poste'  >" +
                    "</span>" +
                    " <p  class='describe' style='margin-top: 3px'>"
                    + "<input type='text' id='input2'style='height: 20px;width: 70px' placeholder='entreprise' >"
                    + "<i class='fa fa-circle iconList'></i>" +
                    "<input type='text' id='input3' style='height: 20px;width: 70px'placeholder='contrat'>"
                    + "<i class='fa fa-circle iconList'></i>" +
                    "<input type='date' id='input4' style='height: 20px;width: 70px'>/<input type='date' id='input5'style='height: 20px;width: 70px'>"
                    + "<i class='fa fa-circle iconList'></i>" +
                    "<input type='text' id='input6' style='height: 20px;width: 70px'placeholder='ville'>-<input type='text' id='input7'style='height: 20px;width: 70px' placeholder='pays'>"
                    + "<div class='left-column pull-right'>"
        +"<div id='drag-and-drop-zone' class='uploader'>"
            +"<div>Glisser votre Logo</div>"
        +"<div class='or'>-ou-</div>"
            +"<div id='browser' class='browser'>"
            +"<label>"
            +"<span>Browser</span>"
        +"<input type='file' id='logo' title='Click to add Files'>"
            +"</label>"
            +"</div>"
            +"</div>"
        +"</div>"
                    + "</p><ul class='listAdd'  id='listItem'> <li ><input ><button class='add icon-plus' > </button> </li></ul>"
                    +"</div>";}

            if(nature=="competences"){
                bloc=     '<div class="row " id="elementAjouter">'+

                    '<div class="col-md-3 col-xs-12 competence-area {{app.themeCV.titleItem}} ">'+
                    '<span><input type="text" id="input1" style="width: 135px"></span>'+
                    '</div>'+
                    '<div class="col-md-3 col-xs-12  " style="bottom: 0px;" id="blocCompetence0" >'+
                    '<div class="competence-item" >'+
                    '<div style="margin-left: 20px"><select id="competenceAded0">'+
                    '<option value="-1">---</option>'+
                    '</select></div>'+
                    '<div id="progressBar0" class="meter" style="margin-left: 15px"><span  class="'+$scope.app.themeCV.titleBloc+'"  style="width:50%"></span></div>'+
                    '</div>'+
                    '</div>'+
                    '</div>'
            }
            if(nature=="liens")
            {bloc='<div id="elementAjouter"> <div style="margin-top: 5px;margin-left: 58px;"><select id="selectLien" tabindex="1">'+
                    '<option contact="lien" value="fa-link">Lien</option>'+
                '<option contact=null value="fa-facebook-square fa-2x" data-icon="./img/facebook-logo.gif" >facebook</option>'+
                '<option contact=null value="fa-github-square fa-2x" data-icon="./img/github-logo.png">Github</option>'+
            '</select><input id="inputLien"><div><button   id="saveLien" class="btn btn-round btn-xs" ng-click="saveElement()"><span class="glyphicon glyphicon-ok" style="color: #219ed5"></span></button></div></div></div>'
            }
            if(nature=="contacts")
            {bloc='<div id="elementAjouter"> <div style="margin-top: 5px;margin-left: 58px;"><select id="selectLien" tabindex="1">'+
                '<option contact="lien" value="fa-link">Contact</option>'+
                '<option  contact="skype:" value="fa-skype" data-icon="./img/skype-logo.png">skype</option>'+
                '<option contact="tel:" value="fa-phone" data-icon="./img/telephone-logo.png">telephone</option>'+
                '<option contact="mailto:" value="fa-envelope" data-icon="./img/email-logo.png">Email</option>'+
                '</select><input id="inputLien"><div><button   id="saveLien" class="btn btn-round btn-xs" ng-click="saveElement()"><span class="glyphicon glyphicon-ok" style="color: #219ed5"></span></button></div></div></div>'
            }
            if(nature=="langues")
            {bloc='<div id="elementAjouter"> <div style="margin-top: 5px;"><select id="selectLien" tabindex="1">'+
                '<option logo="langue" value="fa-link">Langue</option>'+
                '<option  logo="img/GB_lang.jpg" value="anglais" data-icon="img/AU.png">Anglais</option>'+
                '<option logo="img/FR_lang.jpeg" value="francais" data-icon="img/France.png">Francais</option>'+
                '<option logo="img/Ar_lang.jpg" value="arabe" data-icon="img/arabe.jpg">Arabe</option>'+
                '</select><button   id="saveLien" class="btn btn-round btn-xs" ng-click="saveLangue()"><span class="glyphicon glyphicon-ok" style="color: #219ed5"></span></button></div></div></div>'
            }

            $("#"+nature).append($compile(bloc)($scope));
            $("#competenceAded0").tinyselect({ dataUrl:"competence.json"});
           $('#progressBar0').click( function (e) {
                var position = $('#progressBar0').offset();
                var clickValue=(e.pageX-position.left)*0.90
                $('#progressBar0 span').css('width',clickValue+'%');

            });
            $('#progressBar0').mousemove(function(e){
                var position = $('#progressBar0').offset();
                var clickValue=(e.pageX-position.left)*0.90
                $('#progressBar0 span').css('width',clickValue+'%');

            })
            $('#selectLien').wSelect();
            blocAdd=true;
            $(".add").click(addItem);
            //affect drag and drop logo experience
            $('#drag-and-drop-zone').bind({
                dragenter:function(e){
                    e.preventDefault();
                    $('.uploader').css( 'border', '2px dotted green');

                },
                dragover:function(e){
                    e.preventDefault();
                    $('.uploader').css( 'border', '2px dotted green');


                },
                dragleave:function(e){
                    e.preventDefault();
                    $('.uploader').css( 'border', '2px dotted #92AAB0');


                }

            })
            $('#drag-and-drop-zone').bind('drop', function(e) {
                $('.uploader').css( 'border', '2px dotted #92AAB0');
                if (e != null) {
                    e.preventDefault();
                }
                var dt = e.dataTransfer || (e.originalEvent && e.originalEvent.dataTransfer);
                var files = e.target.files || (dt && dt.files);
                if (files) {
                    logo=files[0];
                }

            })
            //pour ajouter des inputs de types date au browser qui ne sont pas compatible
            if(!Modernizr.inputtypes.date) {
            var date = new Date();
            var currentMonth = date.getMonth();
            var currentDate = date.getDate();
            var currentYear = date.getFullYear();

            $('input[type=date]').datepicker({
                minDate: new Date(currentYear, currentMonth, currentDate),
                dateFormat: "yy-mm-dd"
            });}

            //ajout logo
            $('#logo').on('change',function(){logo= this.files[0]});
            $('#competenceAded0').on('change',addselect);


        }
        else
        {    $('.addLien i').removeClass("fa-reply").addClass("fa-plus");
            $(".buttonAdd a i").removeClass("fa-reply");
            $(".buttonAdd a span").text("Ajouter Formation");
            $(".buttonAdd a i").addClass(" fa-plus");
            $("#elementAjouter").remove();
            blocAdd=false;
            compt = 0;
        }
    };

//==================================================== drag and drop photo de profil====================================================//

// the target size
    var file;
    var TARGET_W=500;
    var TARGET_H=500;
    //drag and drop event
    $('#photo_container img').bind({
        dragenter:function(e){
            e.preventDefault();
            $('#photo_container img').css( 'opacity', '0.7');

        },
        dragover:function(e){
            e.preventDefault();
            $('#photo_container img').css( 'opacity', '0.7');


        },
        dragleave:function(e){
            e.preventDefault();
            $('#photo_container img').css( 'opacity', '1');


        }

    });
    $('#photo_container img').bind('drop', function(e) {
        $('#photo_container img').css( 'opacity', '1');
        if (e != null) {
            e.preventDefault();
        }
        var dt = e.dataTransfer || (e.originalEvent && e.originalEvent.dataTransfer);
        var files = e.target.files || (dt && dt.files);
        if (files) {
           file=files[0];
            $scope.submit_photo();
        }

    });
    // affichage/cache du button modifier photo
    $scope.afficheButtonModifPhoto=function(){
       $('#photo_container').css( 'cursor', 'pointer' );
        $('#photo_container img').css( 'opacity', '0.7');
    } ;
    $scope.cacherButtonModifPhoto=function(){
        $('#photo_container').css( 'cursor', 'Default' );
        $('#photo_container img').css( 'opacity', '1');
    };
    // show_popup_crop : show the crop popup
    var show_popup_crop=function (url) {
        // destroy the Jcrop object to create a new one
        try {
            jcrop_api.destroy();
        } catch (e) {
            // object not defined
        }
        // change the photo source
        $('#cropbox').attr('src', "php/"+url);
        // Initialize the Jcrop using the TARGET_W and TARGET_H that initialized before
        $('#cropbox').Jcrop({
            boxWidth: 500, boxHeight: 500,
            aspectRatio: TARGET_W / TARGET_H,
            setSelect:   [ 100, 100, TARGET_W, TARGET_H ],
            onSelect: updateCoords
        },function(){
            jcrop_api = this;
        });

        // store the current uploaded photo url in a hidden input to use it later
        $('#photo_url').val(url);
        // hide and reset the upload popup
        $('#popup_upload').hide();
        $('#loading_progress').html('');
        $('#photo').val('');

        // show the crop popup
        $('#popup_crop').show();
    };
    $('#photo').change(function() {
         file = this.files[0];
    });
// show loader while uploading photo
     $scope.submit_photo=function() {
         var form_data = new FormData();
         form_data.append('photo', file);
        // display the loading texte

         var xhr=new XMLHttpRequest();
         xhr.addEventListener('load',function(e){
             var json=JSON.parse(e.target.responseText);
             if(json.error){
                 Notifier.error(json.error);
                 $('#photo').val("");
                 return false
             }
             else {
                 $('#loading_progress').html('<i class="fa fa-2x fa-spinner fa-spin "></i> Uploading your photo...');
                 show_popup_crop(json.name);


             }
         },false);
         xhr.open('post', 'php/upload_photo.php',true);
         xhr.setRequestHeader('content-type','multipart/form-data');
         xhr.setRequestHeader('x-file-type',file.type);
         xhr.setRequestHeader('x-file-size',file.size);
         xhr.setRequestHeader('x-file-name',file.name);
         xhr.send(file);



    }

// show_popup : show the popup
     $scope.show_popup=function(id) {
        // show the popup
        $('#'+id).show();
    }

// close_popup : close the popup
    $scope.close_popup=function (id) {
        // hide the popup
        $('#'+id).hide();
    }



// crop_photo :
     $scope.crop_photo= function(){
        var x_ = $('#x').val();
        var y_ = $('#y').val();
        var w_ = $('#w').val();
        var h_ = $('#h').val();
        var photo_url_ = $('#photo_url').val();

        // hide thecrop  popup
        $('#popup_crop').hide();


        // display the loading texte
         $('<span class="loadingPhoto "><i class="fa fa-2x fa-spinner fa-spin "></i>Loading...</span>').appendTo('#photo_container');
        // crop photo with a php file using ajax call
        $.ajax({
            url: 'php/crop_photo.php',
            type: 'POST',
            data: {x:x_, y:y_, w:w_, h:h_, photo_url:photo_url_, targ_w:TARGET_W, targ_h:TARGET_H},
            success:function(data){
                // display the croped photo
                $scope.infoCV.photo="php/"+data;
                $('#photo_container span ').remove();
                RestEntry.updateService("http://localhost:8089/CV/update/photoProfil/",'php/'+data, currentCV);
            }

        });

    }

// updateCoords : updates hidden input values after every crop selection
    function updateCoords(c) {
        $('#x').val(c.x);
        $('#y').val(c.y);
        $('#w').val(c.w);
        $('#h').val(c.h);
    }



//==========================================================editable champ==============================================================//

    $scope.update = function(updatedObject,nature) {

        if(nature=='informationPersonnel'){
        RestEntry.updateService("http://localhost:8089/informationpersonnel/update/",updatedObject,updatedObject.idInfoPerso).then(function(d){
            Notifier.success('la modification est pris en charge');
        })}
        if(nature=='experience'){
            RestEntry.updateService("http://localhost:8089/experience/update/",updatedObject,updatedObject.idExperience).then(function(d){
                Notifier.success('la modification est pris en charge');
            })}
        if(nature=='formation'){
            RestEntry.updateService("http://localhost:8089/formation/update/",updatedObject,updatedObject.idFormation).then(function(d){
            Notifier.success('la modification est pris en charge');
        })}
        if(nature=='loisir'){
            RestEntry.updateService("http://localhost:8089/loisir/update/",updatedObject,updatedObject.idLoisir).then(function(d){
                Notifier.success('la modification est pris en charge');
            })}
        if(nature=='informationCV'){

            RestEntry.updateService("http://localhost:8089/CV/update/",updatedObject,updatedObject.idCV).then(function(d){
                Notifier.success('la modification est pris en charge');
            })
        }
        if(nature=='lien'){

            RestEntry.updateService("http://localhost:8089/lien/update/",updatedObject,updatedObject.idLiens).then(function(d){
                Notifier.success('la modification est pris en charge');
            })
        }
        if(nature=='competence'){

            RestEntry.updateService("http://localhost:8089/competence/update/",updatedObject,updatedObject.idCompetence).then(function(d){
                Notifier.success('la modification est pris en charge');
            })
        }
    };
//==============================================setting bar=====================================//
$scope.whatClassIsIt=function(x){
        if(x==true)
        return "photo_profil1"
    else
        return "photo_profil2"
    }

    $('.souma').css('font-family',$scope.app.settings.stylePolice);
    $('.bfh-fonts').bfhfonts({font: $scope.app.settings.stylePolice});
    $('#fontselect').on('change.bfhselectbox', function(e) {
        $scope.app.settings.stylePolice=$(this).val();
        $('.souma').css('font-family',$scope.app.settings.stylePolice);


    });
    $scope.designeCV=function(x){
        if(x==true){
        $('.left-bar').addClass('col-md-push-8')
            return "col-md-pull-4"}
        else{
            $('.left-bar').removeClass('col-md-push-8')
            return ""}
    }
    $('.rating-input').on('rating.change', function(event, value, caption) {
        console.log(event);
        console.log(caption);
    });


});



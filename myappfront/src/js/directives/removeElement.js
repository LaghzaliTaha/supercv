/**
 * Created by alibousenna on 04/05/2016.
 */
angular.module('app').directive("ngRvitem", function(RestEntry) {
    return {
        restrict: 'A',
        link: function(scope, element) {

            var button='<img id="deleteButton" src="img/Button-Delete-icon.png" style="height: 15px;width: 15px;z-index: 77777;position: absolute;top:-6px;left: 99%">'

            element.mouseenter(function(){
                $('#deleteButton').remove();
                element.parent().css('border','1px  dashed')
                element.parent().css('border-radius','5px')
                element.append(button);
                $('#deleteButton').click(function(){
                    data=element.attr('data')
                    if(element.attr('id')=='experience')
                    {
                        RestEntry.deleteService("http://localhost:8089/experience/delete/",data).then(function(d){
                            Notifier.success('le bloc a ete bien supprimer')
                            element.parent().remove();
                        });
                    }
                    if(element.attr('id')=='formation')
                    {
                        RestEntry.deleteService("http://localhost:8089/formation/delete/",data).then(function(d){
                            Notifier.success('le bloc a ete bien supprimer')
                            element.parent().remove();
                        });
                    }
                    if(element.attr('id')=='loisir')
                    {
                        RestEntry.deleteService("http://localhost:8089/loisir/delete/",data).then(function(d){
                            Notifier.success('le bloc a ete bien supprimer')
                            element.parent().remove();
                        });
                    }
                    if(element.attr('id')=='competence')
                    {

                        RestEntry.deleteService("http://localhost:8089/competence/delete/",data).then(function(d){
                            Notifier.success('le bloc a ete bien supprimer')
                            element.parent().remove();
                        });
                    }
                    if(element.attr('id')=='lien'||element.attr('id')=='contact')
                    {

                        RestEntry.deleteService("http://localhost:8089/lien/delete/",data).then(function(d){
                            Notifier.success('le bloc a ete bien supprimer')
                            element.parent().remove();
                        });
                    }

                    if(element.attr('id')=='itemcompetence')
                    {
                        RestEntry.deleteService("http://localhost:8089/itemCompetence/delete/",data).then(function(d){
                            Notifier.success('le bloc a ete bien supprimer')
                            element.parent().remove();
                        });
                    }
                    if(element.attr('id')=='itemExperience')
                    {
                        var item=element.attr('item');
                        RestEntry.deleteService("http://localhost:8089/experience/deleteMission/"+item+"/",data).then(function(d){
                            Notifier.success('le bloc a ete bien supprimer')
                            element.parent().remove();
                        });

                    }
                    if(element.attr('id')=='specialite')
                    {
                        var item=element.attr('item');
                        RestEntry.deleteService("http://localhost:8089/formation/deleteSpecialite/"+item+"/",data).then(function(d){
                            Notifier.success('le bloc a ete bien supprimer')
                            element.parent().remove();
                        });

                    }
                    if(element.attr('id')=='detaille')
                    {
                        var item=element.attr('item');
                        RestEntry.deleteService("http://localhost:8089/loisir/deleteDetaille/"+item+"/",data).then(function(d){
                            Notifier.success('le bloc a ete bien supprimer')
                            element.parent().remove();
                        });

                    }
                    if(element.attr('id')=='language')
                    {
                        RestEntry.deleteService("http://localhost:8089/language/delete/",data).then(function(d){
                            Notifier.success('le bloc a ete bien supprimer')
                            element.parent().remove();
                        });

                    }




                })
            })
            element.mouseleave(function(){
                element.parent().css('border','0px ')
                element.parent().find('#deleteButton').remove();
                element.css('border','0px ')
                element.find('#deleteButton').remove();
            })
        }
    }});

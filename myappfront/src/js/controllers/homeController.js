app.controller('homeController'  , function($scope,$state,userInfo,RestEntry,$window) {
    $(function() {
        var currentUser=JSON.parse(userInfo.getUserInfo());
        var showcase = $("#showcase"), title = $('#item-title')
        $('.cloud9-item').dblclick(function(){
            var themeChoisie=1;
            $window.sessionStorage["TemplateResume"]=themeChoisie
            RestEntry.postService("http://localhost:8089/CV/"+currentUser.id+"/"+themeChoisie+"").then(function(d){
                $window.sessionStorage["ID-CV"]=d;

                $state.transitionTo('app.dashboard-v1', null, {'reload':true});



            },function(e){
                Notifier.error("verifier que vous etes connectez à votre connection internet");
            });

        })

        showcase.Cloud9Carousel( {
            yOrigin: 42,
            yRadius: 48,
            mirror: {
                gap: 12,
                height: 0.2
            },
            buttonLeft: $("#nav > .left"),
            buttonRight: $("#nav > .right"),
            autoPlay: 1,
            bringToFront: true,
            onRendered: rendered,
            onLoaded: function() {
                showcase.css( 'visibility', 'visible' )
                showcase.css( 'display', 'none' )
                showcase.fadeIn( 1500 )
            }
        } )

        function rendered( carousel ) {
            title.text( carousel.nearestItem().element.alt )

            // Fade in based on proximity of the item
            var c = Math.cos((carousel.floatIndex() % 1) * 2 * Math.PI)
            title.css('opacity', 0.5 + (0.5 * c))
        }

        //
        // Simulate physical button click effect
        //
        $('#nav > button').click( function( e ) {
            var b = $(e.target).addClass( 'down' )
            setTimeout( function() { b.removeClass( 'down' ) }, 80 )
        } )

        $(document).keydown( function( e ) {
            //
            // More codes: http://www.javascripter.net/faq/keycodes.htm
            //
            switch( e.keyCode ) {
                /* left arrow */
                case 37:
                    $('#nav > .left').click()
                    break

                /* right arrow */
                case 39:
                    $('#nav > .right').click()
            }
        } )

    })

})
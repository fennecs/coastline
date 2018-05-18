
/*=============================================================
    Authour URI: www.binarytheme.com
    License: Commons Attribution 3.0

    http://creativecommons.org/licenses/by/3.0/

    100% To use For Personal And Commercial Use.
    IN EXCHANGE JUST GIVE US CREDITS AND TELL YOUR FRIENDS ABOUT US
   
    ========================================================  */


(function ($) {
    "use strict";
    var mainApp = {

        metisMenu: function () {

            /*====================================
            METIS MENU 
            ======================================*/

            $('#main-menu').metisMenu();

        },


        loadMenu: function () {

            /*====================================
            LOAD APPROPRIATE MENU BAR
         ======================================*/

            $(window).bind("load resize", function () {
                if ($(this).width() < 768) {
                    $('div.sidebar-collapse').addClass('collapse')
                } else {
                    $('div.sidebar-collapse').removeClass('collapse')
                }
            });
        },
        slide_show: function () {

            /*====================================
           SLIDESHOW SCRIPTS
        ======================================*/

            $('#carousel-example').carousel({
                interval: 3000 // THIS TIME IS IN MILLI SECONDS
            })
        },
        reviews_fun: function () {
            /*====================================
         REWIEW SLIDE SCRIPTS
      ======================================*/
            $('#reviews').carousel({
                interval: 2000 //TIME IN MILLI SECONDS
            })
        },
        // wizard_fun: function () {
        //     /*====================================
        //     //horizontal wizrd code section
        //      ======================================*/
        //     $(function () {
        //         $("#wizard").steps({
        //             headerTag: "h2",
        //             bodyTag: "section",
        //             transitionEffect: "slideLeft"
        //         });
        //     });
        //     /*====================================
        //     //vertical wizrd  code section
        //     ======================================*/
        //     $(function () {
        //         $("#wizardV").steps({
        //             headerTag: "h2",
        //             bodyTag: "section",
        //             transitionEffect: "slideLeft",
        //             stepsOrientation: "vertical"
        //         });
        //     });
        // },
       
        append_loading: function () {
            //生成一个ajax loading dom
            $('body').append('<div style="display:none;width:100px;margin:0 auto;position:fixed;left:45%;top:45%;" id="loading"><img src="assets/img/loading/loading.gif"/></div>');
        },

        custom_prompt: function () {
            toastr.options.positionClass = 'toast-top-center';
        },

        custom_template: function () {
            String.prototype.temp = function(obj) {
                return this.replace(/\$\w+\$/gi, function(matchs) {
                    var returns = obj[matchs.replace(/\$/g, "")];
                    return (returns + "") === "undefined"? "": returns;
                });
            };
        }
    };
    $(document).ready(function () {
        mainApp.metisMenu();
        mainApp.loadMenu();
        mainApp.slide_show();
        mainApp.reviews_fun();
        mainApp.append_loading();
        mainApp.custom_prompt();
        mainApp.custom_template();

        Date.prototype.Format = function (fmt) { //author: meizz
            var o = {
                "M+": this.getMonth() + 1, //月份
                "d+": this.getDate(), //日
                "h+": this.getHours(), //小时
                "m+": this.getMinutes(), //分
                "s+": this.getSeconds(), //秒
                "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                "S": this.getMilliseconds() //毫秒
            };
            if (/(y+)/.test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            }
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;

        };


    });

}(jQuery));

/* ip + port*/
const server_address = window.location.host;




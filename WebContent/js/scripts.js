
function showandHideHiddenPanels(selectorhiddenObject,event){
    if(!selectorhiddenObject){//you clicked somewhere  on body 
        if(popsActive){
            popsActive=false;
            jQuery(".hiddenOptions").hide(100); 
        }
        return;
    }else if(selectorhiddenObject==".hiddenOptions"){//you clicked on an open panel
        event.stopImmediatePropagation();
        return;
    }else{ 
        event.stopImmediatePropagation();//don't handle Event along to body clicked Event
        if(popsActive){
            if(jQuery(selectorhiddenObject).css("display")!="none"){//if open close it
                jQuery(selectorhiddenObject).hide(100);
                popsActive=false 
            }else{//not open but close other Panels
                jQuery(".hiddenOptions").hide();
                jQuery(selectorhiddenObject).show(100);
            }
        }else{ //none open
            jQuery(selectorhiddenObject).show(100);
            popsActive=true; 
        }
    }
}
$('#login form').submit(function(e){
	e.preventDefault();
	var username = $("#username input").attr('value');
	var password = $("#password input").attr('value');
	$.ajax({
		type: "POST",
		timeout: 7000,
		data: {username: username, password: password},
		url: "login",
		success: function(result) {
			if(result != "true") {
				$("#ajax_load").animate({opacity: 1.0}, 500).fadeOut(500);
				$("#messages").append('<div id="ajax_error">Anmeldung war nicht erfolgreich!</div>');
				$("#login").Shake(4);
			}
			else {
				$("#ajax_load").fadeOut(200);
				$("#messages").append('<div id="ajax_accept">Erfolgreich, sende an System...</div>');
				$("#ajax_accept").hide().show("slow",function(){ 
					setTimeout(function(){$("#login").slideUp(500);},500);
					setTimeout(function(){$('#login form')[0].submit();},1200);
				});
			}
		}
	})
});
$jQuery(".button")
		.ajaxStart(function(){
			$("#messages div").remove();
			$("#messages").append('<div id="ajax_load">Überprüfe Daten...</div>');
		});
function changeTimeChooserValue(event){
        jQuery(".checkedListItem.selected").toggleClass("selected");//hide sign
        var liTrigger=jQuery(event.currentTarget);
        liTrigger.children("span.checkedListItem").toggleClass("selected");//show Sign
        liTrigger=liTrigger.children("label");//get LABEL in LI
        jQuery("#tcL_button label").html(liTrigger.text());//set buttonLabel
        jQuery("#tcL_selectValue").val(liTrigger.attr("id")); //set hiddenInputValue
        jQuery(".hiddenOptions").hide(100);//hide Content 
    }
var popsActive=false;
var mouseDownonRange=false;
jQuery(function() {
    jQuery( "#slider-range" ).slider({
        range: true,
        min: 0,
        max: 500,
        values: [ 75, 300 ],
        slide: function( event, ui ) {
            jQuery( "#minAmount" ).val(ui.values[ 0 ] );
            jQuery( "#maxAmount" ).val(ui.values[ 1 ] );
        }
    });
    jQuery('#rangemaxDrag,#rangeminDrag').mousedown(function(){
        mouseDownonRange=true;
    });
    jQuery('#rangemaxDrag,#rangeminDrag').mouseup(function(){
        if(mouseDownonRange=="out"){
            jQuery("#slider-range").hide(50);
        }
        mouseDownonRange=false;
    });
    jQuery("#minAmount,#maxAmount").focus(function(){ 
       jQuery(this).addClass("textinputFocused");
    });
     jQuery("#minAmount,#maxAmount").blur(function(){
        jQuery(this).removeClass("textinputFocused");
    });
    jQuery("#minAmount,#maxAmount").keyup(function(){  
        if(this.value.length>=4&& this.value.length>0){
            this.size=this.value.length-1;
        }else{
            this.size=3;
        }
    });
    
    jQuery( "#minAmount" ).val( jQuery( "#slider-range" ).slider( "values", 0 ));
    jQuery( "#maxAmount" ).val( jQuery( "#slider-range" ).slider( "values", 1 ));
//    jQuery( "#amount" ).val( jQuery( "#slider-range" ).slider( "values", 0 ) +" - " + jQuery( "#slider-range" ).slider( "values", 1 ) );
//})
//            
//jQuery(document).ready(function() {          
    jQuery("label").inFieldLabels();
    jQuery("#timechooserList li").click(function(event){
        changeTimeChooserValue(event);
    });
    jQuery("#price").hover(function(){
                mouseDownonRange=false;
               jQuery("#slider-range").show(100); 
            }, function(){
                if(mouseDownonRange){
                    mouseDownonRange="out";
                }else{
                   
                    if($.browser.msie && $.browser.version=="6.0"){
                     jQuery("#slider-range").delay(1000).hide(200);
                       
                    }else{
                         jQuery("#slider-range").delay(200).hide(100);
                    }
                }
            });
    
    jQuery(document).mouseup(function(event){
        if(mouseDownonRange=="out"){
            jQuery("#slider-range").hide(50);
        }
        mouseDownonRange=false;
    }) ;       
    jQuery("#loginBtn").click(function(event){    
        showandHideHiddenPanels("#loginPanel",event);
    });
    jQuery("#timechooser").click(function(event){  
        showandHideHiddenPanels("#timechooser .hiddenOptions",event);            
    });          
    jQuery(".hiddenOptions").click(function(event){     
        showandHideHiddenPanels(".hiddenOptions",event);
        });
    jQuery("#voteLanguageBtn").click(function(event){
        showandHideHiddenPanels("#currLangPanel",event);
    });
     jQuery("#what .inputFormLabels").click(function(event){
        showandHideHiddenPanels("#whatSearchAutocomplete",event);
    });
    jQuery("body").click(function(event){
        showandHideHiddenPanels();
    });  


//jQuery("#whatInput").keydown( function (event) {
//if ((!event.shiftKey && 
//    !event.ctrlKey && 
//    !event.altKey ) && 
//    ((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105))) // 0-9 or numpad 0-9, disallow shift, ctrl, and alt
//{
//return;
//}
//else if (event.keyCode != 8 && event.keyCode != 46 && event.keyCode != 37 && event.keyCode != 39) // not esc, del, left or right
//{
//event.preventDefault();
//}
//}
//);
// else the key should be handled normally 
});
//function capLock(e){
// kc = e.keyCode?e.keyCode:e.which;
// sk = e.shiftKey?e.shiftKey:((kc == 16)?true:false);
// if(((kc >= 65 && kc <= 90) && !sk)||((kc >= 97 && kc <= 122) && sk))
//  document.getElementById('divMayus').style.visibility = 'visible';
// else
//  document.getElementById('divMayus').style.visibility = 'hidden';
//}

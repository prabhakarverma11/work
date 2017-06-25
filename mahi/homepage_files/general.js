/*---------------------------------------------------------------------*/
;(function($){

/*================= Global Variable Start =================*/		   
var isMobile = /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent);
var IEbellow9 = !$.support.leadingWhitespace;
var iPhoneAndiPad = /iPhone|iPod/i.test(navigator.userAgent);
var isIE = navigator.userAgent.indexOf('MSIE') !== -1 || navigator.appVersion.indexOf('Trident/') > 0;
function isIEver () {
  var myNav = navigator.userAgent.toLowerCase();
  return (myNav.indexOf('msie') != -1) ? parseInt(myNav.split('msie')[1]) : false;
}
//if (isIEver () == 8) {}
		   
var jsFolder = "writereaddata/js/";
var cssFolder = "writereaddata/Portal/Design_CSS/";	
var ww = document.body.clientWidth, wh = document.body.clientHeight;
var mobilePort = 8000, ipadView = 1024, wideScreen = 1600;

/*================= Global Variable End =================*/	

//css3 style calling 
document.write('<link rel="stylesheet" type="text/css" href="' + cssFolder +'3.css">');	

/*================= On Document Load Start =================*/	
$(document).ready( function(){
	$('body').removeClass('noJS').addClass("hasJS");
	$(this).scrollTop(0);
	getWidth();
	
	//Set Element to vertical center using padding
	 $.fn.verticalAlign = function () {return this.css("padding-top", ($(this).parent().height() - $(this).height()) / 2 + 'px');};
	 
	setTimeout(function(){
		$('.vCenter').each(function () {$(this).verticalAlign();});
	}, 800);
	
	/*$('a[href="#content"]').click(function(){
		skipTo = $(this).attr('href');
		skipTo = $(skipTo).offset().top;
		$('html, body').animate({scrollTop:skipTo}, '200');
		return false;
	});*/
	
	if($('.inner').length){
		$('.skipContent').click(function(){
			$('html, body').animate({ scrollTop: $('#skipContent').offset().top - 65 }, 300);
			return false;
		});	
	} else {
		$('.skipContent').click(function(){
			$('html, body').animate({ scrollTop: $('#skipContent').offset().top - 72 }, 300);
			return false;
		});
	}
	
	// Index Banner Slider	
	if( $(".sliderBanner").length) {
		var owl = $(".sliderBanner");
		var autoplay;
		if (owl.children().length == 1) {autoplay = false}
		else {autoplay = true}
		
		owl.owlCarousel({
			loop:autoplay
			,autoplay:autoplay
			,mouseDrag:false
			,autoplayTimeout:4500
			,autoplaySpeed:800
			,smartSpeed:1100
			,nav:autoplay	
			,dots:false
			,items : 1
			//,animateOut: 'owlFadeOut'
			//,animateIn: 'owlFadeIn'
			,autoplayHoverPause: true
			//dots : false		
			,onInitialized: function(event) {
				if (owl.children().length > 1) { 
					 //owl.trigger('stop.owl.autoplay');
					 //this.settings.autoplay = true;
					 //this.settings.loop = true;
				}
			}
		});
	};
	
	// Inner Banner Slider	
	if( $(".slider").length) {
		var owl2 = $(".slider");
		var autoplay;
		if (owl2.children().length == 1) {autoplay = false	}
		else {autoplay = true}
		
		owl2.owlCarousel({
			loop:autoplay
			,autoplay:autoplay
			,mouseDrag:autoplay
			,autoplayTimeout:3000
			,autoplaySpeed:800
			,smartSpeed:1200
			,nav:autoplay
			,dots:autoplay
			,items : 1
			,autoplayHoverPause: true
			//dots : false		
			,onInitialized: function(event) {
				if (owl2.children().length > 1) { 
				}
			}
		});
	};
	
	
if( $(".testimonialCarousel").length) {
		$('.testimonialCarousel').owlCarousel({
			 loop:true
			,autoplay:true
			,dots:true
			,autoplayTimeout:3000
			,smartSpeed:1200
			,margin:20
			,mouseDrag: false
			,nav:false
			,responsive:{
				0:{
					items:1
				},
				992:{
					items:1
				},
				993:{
					items:2
				}
			}
		})
	};
	
	if( $(".marqueeScrolling li").length > 1){
		var $mq = $('.marquee').marquee({
			 speed: 25000
			,gap: 0
			,duplicated: true
			,pauseOnHover: true
			});
		$(".btnMPause").toggle(function(){
			$(this).addClass('play');
			$(this).text('Play');
			$mq.marquee('pause');
		},function(){
			$(this).removeClass('play');
			$(this).text('Pause');
			$mq.marquee('resume');
			return false;
		});
	};
	
	// Multiple Ticker	
	if( $(".ticker").length){
		$('.ticker').each(function(i){
			$(this).addClass('tickerDiv'+i).attr('id', 'ticker'+i);
			$('#ticker'+i).find('.tickerDivBlock').first().addClass('newsTikker'+i).attr('id', 'newsTikker'+i);
			$('#ticker'+i).find('a.playPause').attr('id', 'stopNews'+i)
			$('#newsTikker'+i).vTicker({ speed: 1E3, pause: 4E3, animation: "fade", mousePause: false, showItems: 3, height: 150, direction: 'up' })
			$("#stopNews"+i).click(function () {
				if($(this).hasClass('stop')){
					$(this).removeClass("stop").addClass("play").text("Play").attr('title', 'Play');
				}else{
					$(this).removeClass("play").addClass("stop").text("Pause").attr('title', 'pause');
				}
				return false;
			});
		});
	};
	
	
	
	// Responsive Tabing Script
	if( $(".resTab").length) {
		$('.resTab').responsiveTabs({
			 rotate: false
			,startCollapsed: 'tab' //accordion
			,collapsible: 'tab' //accordion
			,scrollToAccordion: true
		});
	};
				
	if( $(".accordion").length){
	   $('.accordion .accordDetail').hide();
	   $(".accordion .accordDetail:first").show(); 
	   $(".accordion .accTrigger:first").addClass("active");	
	   $('.accordion .accTrigger').click(function(){
		  if ($(this).hasClass('active')) {
			   $(this).removeClass('active');
			   $(this).next().slideUp();
		  } else {
			  if ($('body').hasClass('desktop')) {
			   $('.accordion .accTrigger').removeClass('active');
			   $('.accordion .accordDetail').slideUp();
			  }
			   $(this).addClass('active');			   
			   $(this).next().slideDown();
		  }
		  return false;
	   });
	};
	
	if( $(".tableData").length > 0){
		$('.tableData').each(function(){
			$(this).wrap('<div class="tableOut"></div>');
			$(this).find('tr').each(function(){
			$(this).find('td:first').addClass('firstTd');
			$(this).find('th:first').addClass('firstTh');
			$(this).find('th:last').addClass('lastTh');
			});
			$(this).find('tr:last').addClass('lastTr');
			$(this).find('tr:even').addClass('evenRow');
			$(this).find('tr:nth-child(2)').find('th:first').removeClass('firstTh');
		});	
	};
	
	// Responsive Table
	if( $(".responsiveTable").length){
		$(".responsiveTable").each(function(){		
		$(this).find('td').removeAttr('width');
		//$(this).find('td').removeAttr('align');
		var head_col_count =  $(this).find('tr th').size();
		// loop which replaces td
		for ( i=0; i <= head_col_count; i++ )  {
			// head column label extraction
			var head_col_label = $(this).find('tr th:nth-child('+ i +')').text();
			// replaces td with <div class="column" data-label="label">
			$(this).find('tr td:nth-child('+ i +')').attr("data-label", head_col_label);
		}
		});
	};
	
	/*if( $("#myChart").length){
		var ctx = document.getElementById("myChart");
		var myChart = new Chart(ctx, {
	    type: 'horizontalBar',
	    data: {
	        labels: ["", "", "", "", "", ""],
	        datasets: [{
	            label: 'Total',
	            data: [528, 180, 187, 320, 534, 89],
	            backgroundColor: [
	                'rgba(248, 132, 29, 1)',
	                'rgba(248, 132, 29, 1)',
	                'rgba(248, 132, 29, 1)',
	                'rgba(248, 132, 29, 1)',
	                'rgba(248, 132, 29, 1)',
	                'rgba(248, 132, 29, 1)'
	            ],
	            borderColor: [
	                'rgba(248, 132, 29, 1)',
	                'rgba(248, 132, 29, 1)',
	                'rgba(248, 132, 29, 1)',
	                'rgba(248, 132, 29, 1)',
	                'rgba(248, 132, 29, 1)',
	                'rgba(248, 132, 29, 1)'
	            ],
	            borderWidth: 1,
				
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero:true
	                }
	            }]
	        }
	    }
		});
	};*/
	
	// Responsive Table
	if( $(".tableScroll").length){
		$(".tableScroll").each(function(){
			$(this).wrap('<div class="tableOut"></div>');
		});
	};
	
	// Back to Top function
	if( $("#backtotop").length){
		$(window).scroll(function(){
			if ($(window).scrollTop()>120){
			$('#backtotop').fadeIn('250').css('display','block');}
			else {
			$('#backtotop').fadeOut('250');}
		});
		$('#backtotop').click(function(){
			$('html, body').animate({scrollTop:0}, '200');
			return false;
		});
	};
	
	// Get Focus Inputbox
	if( $(".getFocus").length){
			$(".getFocus").each(function(){
			$(this).on("focus", function(){
			if ($(this).val() == $(this)[0].defaultValue) { $(this).val("");};
		  }).on("blur", function(){
			  if ($(this).val() == "") {$(this).val($(this)[0].defaultValue);};
		  });								  
		});
	};
	
	// For device checking
	if (isMobile == false) {
	
	};
	
	// Video JS
	if( $(".videoplayer").length){	
		$(".videoplayer").each(function(){
			var $this = $(this);
			var poster = $this.children("a").find("img").attr("src");
			var title = $this.children("a").find("img").attr("alt");	
			var videotype = $this.children("a").attr("rel");
			var video = $this.children("a").attr("href");
			$this.children("a").remove();
			
			projekktor($this, {
			 poster: poster
			,title: title
			,playerFlashMP4: '../videoplayer/jarisplayer.swf'
			,playerFlashMP3: '../videoplayer/jarisplayer.swf'
			,width: 640
			,height: 385
			,fullscreen:true
			,playlist: [
				{0: {src: video, type: videotype}}
			],
			plugin_display: {
				logoImage: '',
				logoDelay: 1
			}
			}, function(player) {} // on ready 
			);
		})
	};
	
	if( $(".customSelect").length){	
		$('.customSelect').customSelect();
	};
	
	/*var prm = Sys.WebForms.PageRequestManager.getInstance();
    prm.add_endRequest(function () {
		   if( $(".customSelect").length){	
			$('.customSelect').customSelect();
		};
    });*/
	
	// Google Map gmap3 
	if( $("#gmap").length){	
	
		var lang = 23.021666;
		var lati = 72.55464;
		var contentString = '<div id="content">'+
	    '<strong>' + 'Silver Touch Technologies Limited' + '</strong>'+
	    '<div id="bodyContent">'+ '2nd Floor, Saffron Towers,' + '<br/>' +
		'Near Panchwati Circle,' + '<br/>' +
		'Ahmedabad, Gujarat 380006'
	    '</div></div>';
		
		var map = new google.maps.Map(document.getElementById('gmap'), {
		zoom: 15
		,center: new google.maps.LatLng(lang , lati)
		,mapTypeId: google.maps.MapTypeId.ROADMAP
		});	
		
	    var infowindow = new google.maps.InfoWindow({
	        content: contentString
	    });
		google.maps.event.addListener(map, 'click', function() {
		  infowindow.close();
		});
		var marker = new google.maps.Marker({
		  map: map,
		  position: new google.maps.LatLng(lang , lati)
		});
		google.maps.event.addListener(marker, 'click', function() {
	        infowindow.open(map,marker);
	    });
		infowindow.open(map,marker);
	};
	
	if( $(".litebox").length){	
		$('.litebox').liteBox();
	};	
	
	
	
	$('.equalHeights > div').equalHeight();
	
	setTimeout (function(){
		if( $(".fixedErrorMsg").length){					 
			$(".fixedErrorMsg").slideDown("slow");				 
			setTimeout( function(){$('.fixedErrorMsg').slideUp();},5000 );
		}
		if( $(".fixedSuccessMsg").length){					 
			$(".fixedSuccessMsg").slideDown("slow");				 
			setTimeout( function(){$('.fixedSuccessMsg').slideUp();},5000 );
		}
	},500);
	
	/*================= On Document Load and Resize Start =================*/
	$(window).on('resize', function () {
									 
		ww = document.body.clientWidth; 
		wh = document.body.clientHeight;		
		
		$('.vCenter').each(function () {$(this).verticalAlign();});	
		
		if($("body").hasClass("mobilePort")){
			$("body").removeClass("wob");
		}
		
		//$('.container').resize(function(){});
		if (ww < 1023) {
			$('body').hasClass('mobilePort');
			$('body').removeClass('wob');
		}
		
    }).trigger('resize');
	/*================= On Document Load and Resize End =================*/
	
	/*Navigation */
	if( $("#nav").length) {
		if($(".toggleMenu").length == 0){
			$("#mainNav").prepend('<a href="#" class="toggleMenu"><span class="mobileMenu">Menu</span><span class="iconBar"></span></a>');	
		}		

		$(".toggleMenu").click(function() {
			$(this).toggleClass("active");
			$("#nav").slideToggle();
			return false;
		});
		$("#nav li a").each(function() {
			if ($(this).next().length) {
				$(this).parent().addClass("parent");
			};
		})
		$("#nav li.parent").each(function () {
			if ($(this).has(".menuIcon").length <= 0) $(this).append('<i class="menuIcon">&nbsp;</i>')
		});
		dropdown('nav', 'hover', 1);
		adjustMenu();	
	};
	
if($('.datepicker').length){
	$.datepicker.setDefaults({
	  showOn: "both"
	  ,dateFormat:"dd/mm/yy"
	  ,changeMonth: true
	  ,changeYear: true
	  //,buttonImage: "images/calendar.png"
	 //,buttonImageOnly: true
	  ,shortYearCutoff: 50
	  ,buttonText: "<span class='sprite calIcon'></span>"
	  ,beforeShow: function (textbox, instance) {
		instance.dpDiv.css({
			marginTop: /*(textbox.offsetHeight)*/ 0 + 'px'
			,marginLeft: 0 + 'px'
		});
		}
	});
	
	$( ".datepicker" ).datepicker({
		   dateFormat:"dd/mm/yy"
		   ,showOn: "both"
		   ,buttonText: "<span class='sprite calIcon'></span>"
		   ,shortYearCutoff: 50
		 //,buttonImage: "images/calendar.png"
		 //,buttonImageOnly: true
		   ,beforeShow: function (textbox, instance) {
			instance.dpDiv.css({
					marginTop: /*(textbox.offsetHeight)*/ 0 + 'px'
					,marginLeft: 0 + 'px'
					});
			}
	  });	
}

if( $(".datetimepicker").length){
	$( ".datetimepicker" ).datetimepicker({
           dateFormat:"dd-mm-yy", 
           showOn: "both",
		   buttonText: "<span class='sprite calIcon'></span>",
           //buttonImage: "images/calendar.png"
           //buttonImageOnly: true,
		   beforeShow: function (textbox, instance) {
            instance.dpDiv.css({
                    marginTop: /*(textbox.offsetHeight)*/ 15 + 'px',
                    marginLeft: -13 + 'px'
            		});
    		}
      });
}

	
	// Message on Cookie Disabled
	$.cookie('cookieWorked', 'yes', { path: '/' });
	if ($.cookie('cookieWorked') == 'yes') {
		}
	else{
		if( $("div.jsRequired").length == 0){
			$("body").prepend(
				'<div class="jsRequired">Cookies are not enabled on your browser. Need to adjust this in your browser security preferences. Please enable cookies for better user experience.</div>'
			);	
		}
	}

	//counter
	/*if($('.count').length){
		$('.count').counterUp({
			delay: 10,
			time: 3000
		});
	}*/

	//counter
	/*var s = skrollr.init({
		edgeStrategy: 'set',
		easing: {
			WTF: Math.random,
			inverted: function(p) {
				return 1-p;
			}
		}
	});*/

	$('.sliderBanner').parallax("100%", 0.4);
	$('.homeSectionTestionial').parallax("50%", 0.4);

	//Header
	if($('.headerInner').length){
		$(window).scroll(function(){
			$(window).on('resize', function(){
				if($(window).width() > 1200){
					if($(window).scrollTop() > 165){
						$('.headerInner').addClass('slidePanel animated fadeInDown');
					} else {
						$('.headerInner').removeClass('slidePanel animated fadeInDown');
					}
				} else {
					$('.headerInner').removeClass('slidePanel animated fadeInDown');
				}
			}).trigger('resize');
		});
	}


	/*if($('.counter').length){
		$('.counter').clone().addClass('counterMobile').appendTo('.homeSectionBottom .container');
		
		$('.counterMobile').owlCarousel({
			 loop:true
			,autoplay:true
			,dots:false
			,autoplayTimeout:3000
			,smartSpeed:1200
			,margin:20
			,mouseDrag: false
			,nav:true
			,responsive:{
				0:{
					items:1
				},
				480:{
					items:2
				},
				600:{
					items:3
				}
			}
		});

		$(window).on('resize', function(){
			if($(window).width() > 992){
				$('.counter').show();
				$('.counter.counterMobile').hide();
			} else {
				$('.counter').hide();
				$('.counter.counterMobile').show();
			}
		});
	}
	
});*/

if($('.counter').length){
		$('.counter').clone().addClass('counterMobile').appendTo('.counterRow .container');
		$('.counterMobile').owlCarousel({
			 loop:true,
			autoplay:true,
			dots:false,
			autoplayTimeout:3000,
			smartSpeed:1200,
			margin:20,
			mouseDrag: false,
			nav:true,
			responsive:{
				0:{
					items:1
				},
				480:{
					items:2
				},
				600:{
					items:3,
					autoplay:false,
					nav:false,
				}
			}
		});

		$(window).on('resize', function(){
			if($(window).width() > 1200){
				$('.counter').show();
				$('.counter.counterMobile').hide();
			} else {
				$('.counter').hide();
				$('.counter.counterMobile').show();
			}
		});
	}
	
	if($('.count').length){
		$('.count').counterUp({
			delay: 10,
			time: 3000
		});
	}
});
/*================= On Document Load End =================*/

/*================= On Window Resize Start =================*/	
$(window).bind('resize orientationchange', function() {
	getWidth();												
	adjustMenu();
	$('.vCenter').each(function () {$(this).verticalAlign();});
});

/*================= On Window Resize End =================*/	

/*================= On Window Load Start =================*/
$(window).load(function() {
						
});
/*================= On Document Load End =================*/


function getWidth() {
	ww = document.body.clientWidth;
	if(ww>wideScreen){$('body').removeClass('device').addClass('desktop widerDesktop');}
	if(ww>mobilePort && ww<=wideScreen){	$('body').removeClass('device widerDesktop').addClass('desktop');}
	if(ww<=mobilePort) {$('body').removeClass('desktop widerDesktop').addClass('device');}
	if(ww > 767 && ww < 1025){$('body').addClass('ipad');}
	else {$('body').removeClass('ipad');}	
}

})(jQuery);


function validate() {
    return false;
};
$(function(){
	$("#slideDemo").slide({ 
		trigger: "click", 
		effect: "scrollx", 
		auto: true, 
		seamless: true, 
		duration: 600, 
		easing: "easeOutCirc",  
		interval:3000 });
});
jQuery(document).ready(function(){
	var price=0.0;
	var weight=0.0;
	var spid;
	$("#[id^='cart_price_']").each(function(){
		var ss=jQuery(this).html();
		var h=jQuery(this).attr("id");
		var index=h.split("_")[2];
		var count=$("#cart_count_"+index).html();
		price+=accMul(ss,count);
		$("#cart_price").html(price);
	});
	$("#[id^='cart_weight_']").each(function(){
		var ss=parseInt(jQuery(this).html());
		var h=jQuery(this).attr("id");
		var index=h.split("_")[2];
		var count=$("#cart_count_"+index).html();
		weight+=accMul(ss,count);
		$("#cart_weight").html(weight);
	});
	$("#[id^='shippingMethod_']").each(function(){
		if(jQuery(this).attr("checked")){
			spid=jQuery(this).val();
		}
	});
	ajaxtotalDeliveryFee(spid,weight);
	
	
});

Math.formatFloat = function(f, digit) { 
    // digit = 2; // 涉及保留两位小数的计算时
    var m = Math.pow(10, digit); 
    var tNum = new Number(parseInt(f * m, 10) / m).toFixed(2);
    return tNum; 
}

function ajaxtotalDeliveryFee(d,w){
	$.post(URLPrefix.url+"/cart/ajaxtotalDeliveryFee.jspx", {
		'deliveryMethod':d,
		'weight':w
	}, function(data) {
		if(data.status==1){
			var freight=data.freight;
			var cart_price= $("#cart_price").html();
			var deduceAmount=$("#deduceAmount").html();  
			$("#totalDeliveryFee").html(data.freight);
		    console.log("商品价格:"+cart_price+";优惠券"+deduceAmount+";运费"+freight)
	         var total = Math.formatFloat(parseFloat(cart_price)+parseFloat(freight)-parseFloat(deduceAmount),2);
	           if(total < 0 ){
	        	   total = "0.00";
	           }
			 $("#amount_payable").html(total);			
		}
	},'json');
}

//乘法函数，用来得到精确的乘法结果 
//说明：javascript的乘法结果会有误差，在两个浮点数相乘的时候会比较明显。这个函数返回较为精确的乘法结果。 
//调用：accMul(arg1,arg2) 
//返回值：arg1乘以arg2的精确结果 
function accMul(arg1,arg2) 
{ 
var m=0,s1=arg1.toString(),s2=arg2.toString(); 
try{m+=s1.split(".")[1].length}catch(e){} 
try{m+=s2.split(".")[1].length}catch(e){} 
return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m) 
} 
//给Number类型增加一个mul方法，调用起来更加方便。 
Number.prototype.mul = function (arg){ 
return accMul(arg, this); 
} 


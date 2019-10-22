(function() {
var Ad = function(iId,sHtml,fCode,dStart,dEnd,iWeight) {
	this.iId = iId;
	this.sHtml = sHtml;
	this.fCode = fCode;
	this.dStart = dStart;
	this.dEnd = dEnd;
	this.iWeight = iWeight;
}
var ads = new Array(1);
var adsLen = 0;

ads[adsLen++] = new Ad(1,"<a href=\"http://demo3.jeecms.com\" target=\"_blank\" title=\"\" onclick=\"$.get(\'/ad_click.jspx?id=1\');\">\r\n<img src=\"/jspgou/u/201407/091116578hgi.jpg\" border=\"0\" width=\"981\" height=\"70\"/>\r\n<\/a>\r\n",null,
	null,
	null,
	1);

var indexArr = new Array();
var now = new Date();
for(var i=0,j=0,len=ads.length;i<len;i++){
	if((!ads[i].dStart || now>ads[i].dStart) && (!ads[i].dEnd || now<ads[i].dEnd)) {
		for(var max=j+ads[i].iWeight;j<max;j++) {
			indexArr[j] = i;
		}
	}
}

var rand = parseInt(Math.random() * indexArr.length);
var show = ads[indexArr[rand]];
if(show.sHtml) {
	document.write(show.sHtml);
} else {
	show.fCode();
}
$.get("/ad_display.jspx?id="+show.iId);
})();

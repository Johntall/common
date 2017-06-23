/**
 * 
 */


window.onload=initHead;
function initHead() {
var mydd=document.getElementById("catlist");
mydd.onclick=showList;
mydd.onmouseout=hideList;
window.setInterval(lunbo,3000);
var list=mydd.children[1].children;
for (var i=0;i<list.length;i++ ){
    list[i].onclick=picture;
    }
}


function showList() {
    this.children[1].style.display="block";
}
function hideList() {
	this.children[1].style.display="block";//先不隐藏了
}

var count=0;//轮播循环
function lunbo() {
    var lunbo=document.getElementById("lunbo");
    count++;
    var img="img/lunbo/"+count+".jpg"
    lunbo.children[0].setAttribute("src",img)
    if(count===4){
    	count=1;
    }
}


function picture() {
    var req=new XMLHttpRequest();
    req.open("get","/Tmall01/IndexContent?id="+this.id+"&t="+Math.random(),true);
    req.send();
    var self=this;
    req.onreadystatechange=function(){
    	if (this.readyState===4 && this.status===200){
    		
    		
    		
    		
    		
    		
    		self.innerText=this.responseText;
    	}
    }
}
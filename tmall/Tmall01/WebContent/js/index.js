/**
 * 
 */


window.onload=initHead;
function initHead() {
window.setInterval(lunbo,3000);
var mydd=document.getElementById("catlist");
mydd.onclick=showList;
mydd.onmouseout=hideList;
var list=mydd.children[1].children;//给每个品类都添加onclick事件
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
    		
    	    var json = this.responseText;
            var parse = JSON.parse(json);//解析json数据为数组
        var result=document.getElementById("result");
        result.firstChild.remove();
        var piclist=document.createElement("div");
        for(var pnum=0;pnum<parse.length;pnum++){
        	 var img=document.createElement("img");
             img.src=parse[pnum];
             piclist.appendChild(img);//在图片展示区添加图象元素
        }
        result.appendChild(piclist);
        
    
    		
    		
    		
    	}
    }
}
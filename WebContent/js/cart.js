
/**
 * 加入购物车
 */
function buy(goodsid){
	$.post("goods_buy", {goodsid:goodsid}, function(data){
		if(data=="ok"){
			layer.msg("加入到购物车!", {time:800}, function(){
				location.reload();
			});
		}
		
		
		
//		if(data=="ok"){
//			layer.msg("操作成功!", {time:800}, function(){
//				location.reload();
//			});
//		}else if(data=="login"){
//			alert("请登录后购买!");
//			location.href="login.jsp";
//		}else if(data=="empty"){
//			alert("库存不足!");
//			location.reload();
//		}else{
//			alert("请求失败!");
//		}
	});
}
/**
 * 购物车减去
 */
function lessen(goodsid){
	$.post("goods_lessen", {goodsid:goodsid}, function(data){
		if(data=="ok"){
			layer.msg("操作成功!", {time:800}, function(){
				location.reload();
			});
		}
		
		
		
		
		
//		if(data=="ok"){
//			layer.msg("操作成功!", {time:800}, function(){
//				location.href="cart.action";
//			});
//		}else if(data=="login"){
//			alert("请登录后操作!");
//			location.href="login.jsp";
//		}else{
//			alert("请求失败!");
//		}
	});
}
/**
 * 购物车删除
 */
function deletes(goodid){
	$.post("delete.action", {goodid:goodid}, function(data){
		if(data=="ok"){
			layer.msg("删除成功!", {time:800}, function(){
				location.href="cart.action";
			});
		}else if(data=="login"){
			alert("请登录后操作!");
			location.href="login.jsp";
		}else{
			alert("请求失败!");
		}
	});
}
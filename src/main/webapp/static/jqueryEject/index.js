/**
 * 
 * @authors liningning
 * @date    2019-08-07 15:32:21
 * @version $Id$
 */
function Eject(){
	var _this = this;
	// 全屏遮罩背景
	var qback = $('<div class="qback"></div>')
	// alert提示窗
	_this.Ealert = function(obj){
		var alertBox = $('<div class="alertBox"></div>')
		var alertHead = $('<div class="alertHead">'+obj.title+'</div>')
		var alertMes = $('<div class="alertMes">'+obj.message+'</div>')
		var alertBtn = $('<span class="alertBtn">确定</span>').on('click',function(){
			qback.remove();
			alertBox.remove();
		})
		alertBox.append(alertHead);
		alertBox.append(alertMes);
		alertBox.append(alertBtn);
		qback.append(alertBox);
		$('body').append(qback);
		alertBox.css({'marginTop':-alertBox.outerHeight()/2+'px'});
	}
	// confirm弹窗
	_this.Econfirm = function(obj){
		var confirmBox = $('<div class="alertBox"></div>')
		var confirmHead = $('<div class="alertHead">'+obj.title+'</div>')
		var confirmMes = $('<div class="alertMes">'+obj.message+'</div>')
		var confirmBtn = $('<span class="ConBtn">确定</span>').on('click',function(){
			qback.remove()
			confirmBox.remove()
			setTimeout(function(){
				obj.define()
			},100)
		})
		var confirmcancel = $('<span class="cancel">取消</span>').on('click',function(){
			qback.remove()
			confirmBox.remove()
			setTimeout(function(){
				obj.cancel()
			},100)
		})
		confirmBox.append(confirmHead);
		confirmBox.append(confirmMes);
		confirmBox.append(confirmBtn);
		confirmBox.append(confirmcancel);
		qback.append(confirmBox);
		$('body').append(qback);
		confirmBox.css({'marginTop':-confirmBox.outerHeight()/2+'px'});
	},
	// toast提示
	_this.Etoast = function(mes,time){
		var timer= null;
		var ToastBox = $('<div class="ToastBox">'+mes+'</div>')
		qback.append(ToastBox);
		$('body').append(qback);
		ToastBox.css({'marginTop':-ToastBox.outerHeight()/2+'px'});
		clearInterval(timer)
		timer = setInterval(function(){
			time--
			if(time<=0){
				clearInterval(timer)
				qback.remove()
				ToastBox.remove()
			}
		},1000)
	}
}
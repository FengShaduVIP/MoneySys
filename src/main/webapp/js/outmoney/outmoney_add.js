var id = T.p("id");
var vm = new Vue({
	el:'#rrapp',
	data:{
		title:"新增",
		outMoney:{}
	},
	created: function() {
		if(id != null){
			this.title = "修改";
			this.getInfo(id)
		}
    },
	methods: {
		getInfo: function(id){
			$.get("../outmoney/info/"+id, function(r){
                vm.outMoney = r.outMoney;
            });
		},
		saveOrUpdate: function (event) {
			var url = vm.outMoney.id == null ? "../outmoney/save" : "../outmoney/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.outMoney),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.back();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		back: function (event) {
			history.go(-1);
		}
	}
});
var id = T.p("id");
var vm = new Vue({
	el:'#rrapp',
	data:{
		title:"新增",
		inMoney:{}
	},
	created: function() {
		if(id != null){
			this.title = "修改";
			this.getInfo(id)
		}
    },
	methods: {
		getInfo: function(id){
			$.get("../inmoney/info/"+id, function(r){
                vm.inMoney = r.inMoney;
            });
		},
		saveOrUpdate: function (event) {
			var url = vm.inMoney.id == null ? "../inmoney/save" : "../inmoney/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.inMoney),
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
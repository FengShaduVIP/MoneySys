var id = T.p("id");
var vm = new Vue({
	el:'#rrapp',
	data:{
		title:"新增",
		myMoney:{}
	},
	created: function() {
		if(id != null){
			this.title = "修改";
			this.getInfo(id)
		}
    },
	methods: {
		getInfo: function(id){
			$.get("../mymoney/info/"+id, function(r){
                vm.myMoney = r.myMoney;
            });
		},
		saveOrUpdate: function (event) {
			var url = vm.myMoney.id == null ? "../mymoney/save" : "../mymoney/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.myMoney),
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
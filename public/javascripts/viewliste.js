(function($) {
	GestionnaireListe.ecrans.viewliste = {
		
		deleteArticle : function(id) {
				var buttonDefs = {};
				buttonDefs[GestionnaireListe.messages.buton.oui] = function() {
					var json = {};
					json.id = id;
					
					$.ajax({
						url: GestionnaireListe.routes.deleteArticleRoute,
						type: "POST",
						data: JSON.stringify(json),
						success: self.onSubmitSuccess,
						error: self.onSubmitError,
						dataType: "json",
						contentType: "application/json"
					});
		   	  		$(this).dialog("close");
				};
				buttonDefs[GestionnaireListe.messages.buton.non] = function() {$(this).dialog("close");};
				$("<div>"+GestionnaireListe.messages.deleteArticle+"</div>").dialog({
					modal: true,
					height: 200,
					width: 400,
					buttons: buttonDefs
				});
		},
		
		onSubmitSuccess : function(){
			window.location.reload();		
		},
		
		onSubmitError : function(){
			window.alert('fail');
		}
	};
	
	var self = GestionnaireListe.ecrans.viewliste;
})(jQuery);


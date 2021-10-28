api = (function () {

  return {
      getCases: function(callback) {
          var promiseGetAllCases = $.getJSON("https://kevin-garzon-arsw-t2.herokuapp.com/cases");
          $.when (promiseGetAllCases).done(function (data) {
              callback(data);
          });
      },

      getCasesByCountry: function(country, callback){
          var promiseGetCasesByCountry = $.getJSON("https://kevin-garzon-arsw-t2.herokuapp.com/"+ country);
          $.when (promiseGetCasesByCountry).done(function (data) {
              callback(data);
          });
      }
  }
})();
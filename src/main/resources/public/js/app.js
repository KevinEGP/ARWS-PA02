app = (function (){

  var _module = "js/api.js";
  var _covid19Stats;
  var _selectedCountry;
  var _covid19CountryStats;
  var map;

  function _updateCasesTableData(){
      $("#cases > tbody").empty()
      _covid19Stats.map(function (singleCase) {
          var fila  = `<tr>
                          <td> 
                              <a data-toggle=tab href=#TabCountry 
                                  onclick=app.getStatsCountry('${singleCase.country}','${singleCase.deaths}','${singleCase.infected}','${singleCase.cured}')> 
                                  ${singleCase.country}
                              </a>
                          </td> 
                          <td class="text-center">${singleCase.deaths}</td>
                          <td class="text-center">${singleCase.infected}</td>
                          <td class="text-center">${singleCase.cured}</td>
                      </tr>` 
          $("#cases > tbody").append(fila)
      })
  }

  function _updateCasesData(cases){
      _covid19Stats = [];
      cases.map(function (sigleCase) {
          _covid19Stats.push({country: sigleCase.country, deaths: sigleCase.deaths, infected: sigleCase.confirmed, cured: sigleCase.recovered}); 
      });
      _updateCasesTableData();
  }

  function _updateCountryTableData(){
      $("#casesCountryRegion > tbody").empty()
      _covid19CountryStats.map(function (singleCase) {
          var fila = '<tr><td>'+singleCase.region+'</td><td class="text-center">' + singleCase.deaths + '</td><td class="text-center">' + singleCase.infected + '</td><td class="text-center">' +  singleCase.cured + '</td></tr>';
          $("#casesCountryRegion > tbody").append(fila)
      })
  }

  function _updateStatsCountry(cases){
      _covid19CountryStats = [];
      console.log(cases[0].deaths);
      cases.map(function (sigleCase) {
          _covid19CountryStats.push({region: sigleCase.province, deaths: sigleCase.deaths, infected: sigleCase.confirmed, cured: sigleCase.recovered}); 
      });
      _updateCountryTableData();
      _initMap(cases);
  }

  function _initMap(cases){
      map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: -34.397, lng: 150.644},
          zoom: 8
      });
      plotMarkers(cases);
  }

  var markers;
  var bounds;

  function plotMarkers(m){
      markers = [];
      bounds = new google.maps.LatLngBounds();

      m.forEach(function (marker) {
          console.log(marker.latlng.lat, marker.latlng.lng);
          var position = new google.maps.LatLng(marker.latlng.lat, marker.latlng.lng);

          markers.push(
          new google.maps.Marker({
              position: position,
              map: map,
              animation: google.maps.Animation.DROP
          })
          );

          bounds.extend(position);
      });

      map.fitBounds(bounds);
  }

  return{
      init: function(){
          $.getScript(_module, function () {
              api.getCases(_updateCasesData);
          });
      },

      getStatsCountry: function(country, deaths, infected, cured){
          $("#statsOfCountry > tbody").empty()
          $("#statsOfCountry > tbody").append(`<tr><td class="text-center">Num Deaths</td><td class="text-center">${deaths}</td></tr>`);
          $("#statsOfCountry > tbody").append(`<tr><td class="text-center">Num Infected</td><td class="text-center">${infected}</td></tr>`);
          $("#statsOfCountry > tbody").append(`<tr><td class="text-center">Num Cured</td><td class="text-center">${cured}</td></tr>`);
          document.getElementById("countryname").value = country;
          _selectedCountry = country;
          $.getScript(_module, function () {
              api.getCasesByCountry(country, _updateStatsCountry);
          });
      }
      
  }
})();
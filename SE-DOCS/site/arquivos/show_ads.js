(function(){
var f=document,h=navigator,j=window;function n(){var a=f.cookie,c=Math.round((new Date).getTime()/1000),b=j.google_analytics_domain_name,d=typeof b=="undefined"?r("auto"):r(b),e=a.indexOf("__utma="+d+".")>-1,g=a.indexOf("__utmb="+d)>-1,k=a.indexOf("__utmc="+d)>-1,l,i={};if(e){l=a.split("__utma="+d+".")[1].split(";")[0].split(".");i.sid=g&&k?l[3]+"":j&&j.gaGlobal&&j.gaGlobal.sid?j.gaGlobal.sid:c+"";i.vid=l[0]+"."+l[1];i.from_cookie=true;i.dh=d}else{i.sid=j&&j.gaGlobal&&j.gaGlobal.sid?j.gaGlobal.sid:
c+"";i.vid=j&&j.gaGlobal&&j.gaGlobal.vid?j.gaGlobal.vid:(s()^aa())*2147483647+"."+c;i.from_cookie=false}i.hid=j&&j.gaGlobal&&j.gaGlobal.hid?j.gaGlobal.hid:s();j.gaGlobal=i;return i}function s(){return Math.round(Math.random()*2147483647)}function aa(){var a=f.cookie?f.cookie:"",c=j.history.length,b,d,e=[h.appName,h.version,h.language?h.language:h.browserLanguage,h.platform,h.userAgent,h.javaEnabled()?1:0].join("");if(j.screen)e+=j.screen.width+"x"+j.screen.height+j.screen.colorDepth;else if(j.java){d=
java.awt.Toolkit.getDefaultToolkit().getScreenSize();e+=d.screen.width+"x"+d.screen.height}e+=a;e+=f.referrer?f.referrer:"";b=e.length;while(c>0)e+=c--^b++;return u(e)}function u(a){var c=1,b=0,d,e;if(!(a==undefined||a=="")){c=0;for(d=a.length-1;d>=0;d--){e=a.charCodeAt(d);c=(c<<6&268435455)+e+(e<<14);b=c&266338304;c=b!=0?c^b>>21:c}}return c}function r(a){if(!a||a==""||a=="none")return 1;if("auto"==a){a=f.domain;if("www."==a.substring(0,4))a=a.substring(4,a.length)}return u(a)};var v={google_ad_channel:"channel",google_ad_host:"host",google_ad_host_channel:"h_ch",google_ad_host_tier_id:"ht_id",google_ad_region:"region",google_ad_section:"region",google_ad_type:"ad_type",google_adtest:"adtest",google_alternate_ad_url:"alternate_ad_url",google_alternate_color:"alt_color",google_bid:"bid",google_city:"gcs",google_color_bg:"color_bg",google_color_border:"color_border",google_color_line:"color_line",google_color_link:"color_link",google_color_text:"color_text",google_color_url:"color_url",
google_contents:"contents",google_country:"gl",google_cust_age:"cust_age",google_cust_ch:"cust_ch",google_cust_gender:"cust_gender",google_cust_id:"cust_id",google_cust_interests:"cust_interests",google_cust_job:"cust_job",google_cust_l:"cust_l",google_cust_lh:"cust_lh",google_cust_u_url:"cust_u_url",google_disable_video_autoplay:"disable_video_autoplay",google_ed:"ed",google_encoding:"oe",google_feedback:"feedback_link",google_flash_version:"flash",google_gl:"gl",google_hints:"hints",google_kw:"kw",
google_kw_type:"kw_type",google_language:"hl",google_referrer_url:"ref",google_region:"gr",google_reuse_colors:"reuse_colors",google_safe:"adsafe",google_targeting:"targeting",google_ui_features:"ui",google_video_doc_id:"video_doc_id",google_video_product_type:"video_product_type",google_page_url:"url"},w={google_ad_format:"format",google_ad_output:"output",google_ad_callback:"callback",google_ad_override:"google_ad_override",google_ad_slot:"slotname",google_analytics_uacct:"ga_wpids",google_correlator:"correlator",
google_cpa_choice:"cpa_choice",google_ctr_threshold:"ctr_t",google_image_size:"image_size",google_last_modified_time:"lmt",google_max_num_ads:"num_ads",google_max_radlink_len:"max_radlink_len",google_num_radlinks:"num_radlinks",google_num_radlinks_per_unit:"num_radlinks_per_unit",google_only_ads_with_video:"only_ads_with_video",google_page_location:"loc",google_rl_dest_url:"rl_dest_url",google_rl_filtering:"rl_filtering",google_rl_mode:"rl_mode",google_rt:"rt",google_skip:"skip"};function x(){}x.prototype.n=function(){};x.prototype.o=function(){};x.prototype.m=function(){};var y=null;function z(a){y&&y.n(a)}function A(a){y&&y.o(a)}function ba(a){y&&y.m(a)}function B(){this.b=this.k();this.e=false;if(!this.b){this.e=this.g();this.e||A("Browser does not allow cookies")}}B.prototype.d="__gads=";B.prototype.c="GoogleAdServingTest=";B.prototype.j=function(){return this.b};B.prototype.setCookieInfo=function(a){this.a=a._cookies_[0];if(this.a!=null){this.b=this.a._value_;this.l()}};
B.prototype.i=function(a){var c=(new Date).valueOf(),b=new Date;b.setTime(c+a);return b};B.prototype.h=function(a){if(this.b!=null||!this.e){z("Skipping fetch cookie call");return}var c="script",b=document.domain,d="http://partner.googleadservices.com/gampad/cookie.js?callback=_GA_googleCookieHelper.setCookieInfo&client="+C(a)+"&domain="+C(b);z("Issuing a fetch cookie call with <a href='"+d+"'>"+d+"</a>");document.write("<"+c+' src="'+d+'"></'+c+">")};B.prototype.g=function(){document.cookie=this.c+
"Good";var a=this.f(this.c),c=a=="Good";if(c){var b=this.i(-1);document.cookie=this.c+"; expires="+b.toGMTString()}return c};B.prototype.k=function(){var a=this.f(this.d);a!=null?z("Read first party cookie: "+a):A("No first party cookie found");return a};B.prototype.f=function(a){var c=document.cookie,b=c.indexOf(a),d=null;if(b!=-1){var e=b+a.length,g=c.indexOf(";",e);if(g==-1)g=c.length;d=c.substring(e,g)}return d};B.prototype.l=function(){if(this.a==null)A("Skipping cookie creation: no cookie info");
else if(this.b==null)ba("Skipping cookie creation: no cookie value");else{var a=new Date;a.setTime(1000*this.a._expires_);var c=this.a._domain_,b=this.d+this.b+"; expires="+a.toGMTString()+"; path="+this.a._path_+"; domain=."+c;document.cookie=b;z("Written cookie: "+b)}};function ca(){if(navigator.plugins&&navigator.mimeTypes.length){var a=navigator.plugins["Shockwave Flash"];if(a&&a.description)return a.description.replace(/([a-zA-Z]|\s)+/,"").replace(/(\s)+r/,".")}else if(navigator.userAgent&&navigator.userAgent.indexOf("Windows CE")>=
0){var c=3,b=1;while(b)try{b=new ActiveXObject("ShockwaveFlash.ShockwaveFlash."+(c+1));c++}catch(d){b=null}return c.toString()}else if(da("msie")&&!window.opera){var b=null;try{b=new ActiveXObject("ShockwaveFlash.ShockwaveFlash.7")}catch(d){var c=0;try{b=new ActiveXObject("ShockwaveFlash.ShockwaveFlash.6");c=6;b.AllowScriptAccess="always"}catch(d){if(c==6)return c.toString()}try{b=new ActiveXObject("ShockwaveFlash.ShockwaveFlash")}catch(d){}}if(b!=null){var c=b.GetVariable("$version").split(" ")[1];
return c.replace(/,/g,".")}}return"0"};var ea=ea||{},D=this;var fa=function(a,c){var b=c.length;for(var d=0;d<b;d++){var e=b==1?c:c.charAt(d);if(a.charAt(0)==e&&a.charAt(a.length-1)==e)return a.substring(1,a.length-1)}return a};var E,ga,ha,ia,ja,ka,la,ma,na,oa,F,pa=function(){var a=false,c=false,b=false,d=false,e=false,g=false,k=false,l=false,i=false,p="";if(D.navigator){var o=D.navigator,q=o.userAgent;a=q.indexOf("Opera")==0;c=!a&&q.indexOf("MSIE")!=-1;b=!a&&q.indexOf("WebKit")!=-1;i=b&&q.indexOf("Mobile")!=-1;d=!a&&!b&&o.product=="Gecko";e=d&&o.vendor=="Camino";var m,t;if(a)m=D.opera.version();else{if(d)t=/rv\:([^\);]+)(\)|;)/;else if(c)t=/MSIE\s+([^\);]+)(\)|;)/;else if(b)t=/WebKit\/(\S+)/;if(t){t.test(q);m=RegExp.$1}}p=
o.platform||"";g=p.indexOf("Mac")!=-1;k=p.indexOf("Win")!=-1;l=p.indexOf("Linux")!=-1}E=a;ga=c;ha=d;ia=e;ja=b;ka=i;la=m;ma=p;na=g;oa=k;F=l};pa();var qa=E;var ra=function(a){return typeof a=="string"?document.getElementById(a):a},G=ra;var H=function(a){return a.nodeType==9?a:a.ownerDocument||a.document};var sa=function(a,c){var b=H(a);if(b.defaultView&&b.defaultView.getComputedStyle){var d=b.defaultView.getComputedStyle(a,"");if(d)return d[c]}return null};var ta=function(a){var c=H(a),b="";if(c.createTextRange){var d=c.body.createTextRange();d.moveToElementText(a);b=d.queryCommandValue("FontName")}if(!b){b=sa(a,"fontFamily")||(a.currentStyle?a.currentStyle.fontFamily:null)||a.style.fontFamily;if(qa&&F)b=b.replace(/ \[[^\]]*\]/,"")}var e=b.split(",");if(e.length>1)b=e[0];return fa(b,"\"'")};var K={google:1,googlegroups:1,gmail:1,googlemail:1,orkut:1,googleimages:1,googleprint:1};function ua(a){var c=a.google_page_location||a.google_page_url;if(!c)return false;c=c.toString();if(c.indexOf("http://")==0)c=c.substring(7,c.length);else if(c.indexOf("https://")==0)c=c.substring(8,c.length);var b=c.indexOf("/");if(b==-1)b=c.length;var d=c.substring(0,b),e=d.split("."),g=false;if(e.length>=3)g=e[e.length-3]in K;if(e.length>=2)g=g||e[e.length-2]in K;return g}function va(a,c){var b="http://googleads.g.doubleclick.net",
d="http://pagead2.googlesyndication.com";if(!ua(a)&&Math.random()<c)return b;return d};function L(a){return a!=null?'"'+a+'"':'""'}function C(a){return typeof encodeURIComponent=="function"?encodeURIComponent(a):escape(a)}function M(a,c){if(a&&c)window.google_ad_url+="&"+a+"="+c}function N(a){var c=window,b=v[a]||w[a]||null,d=c[a];M(b,d)}function O(a,c){c&&M(a,C(c))}function P(a){var c=window,b=v[a]||w[a]||null,d=c[a];O(b,d)}function Q(a,c){var b=window,d=v[a]||w[a]||null,e=b[a];if(d&&e&&typeof e=="object")e=e[c%e.length];M(d,e)}function wa(a,c){var b=a.screen,d=navigator.javaEnabled(),
e=-c.getTimezoneOffset();if(b){M("u_h",b.height);M("u_w",b.width);M("u_ah",b.availHeight);M("u_aw",b.availWidth);M("u_cd",b.colorDepth)}M("u_tz",e);M("u_his",history.length);M("u_java",d);navigator.plugins&&M("u_nplug",navigator.plugins.length);navigator.mimeTypes&&M("u_nmime",navigator.mimeTypes.length)}function xa(a){if(!a.google_enable_first_party_cookie)return;if(y==null)y=new x;if(a._GA_googleCookieHelper==null)a._GA_googleCookieHelper=new B;if(!a._google_cookie_fetched){a._google_cookie_fetched=
true;a._GA_googleCookieHelper.h(R(a.google_ad_client))}}function R(a){if(a){a=a.toLowerCase();if(a.substring(0,3)!="ca-")a="ca-"+a}return a}function ya(a){if(a){a=a.toLowerCase();if(a.substring(0,9)!="dist-aff-")a="dist-aff-"+a}return a}function za(a,c,b,d){b=b.substring(0,2000);b=b.replace(/%\w?$/,"");var e="script";if((a.google_ad_output=="js"||a.google_ad_output=="json_html")&&(a.google_ad_request_done||a.google_radlink_request_done))c.write("<"+e+' language="JavaScript1.1" src='+L(b)+"></"+e+
">");else if(a.google_ad_output=="html"){if(a.name!="google_ads_frame"){d!=null&&c.write('<div id="'+d+'">');c.write('<iframe name="google_ads_frame" width='+L(a.google_ad_width)+" height="+L(a.google_ad_height)+" frameborder="+L(a.google_ad_frameborder)+" src="+L(b)+' marginwidth="0" marginheight="0" vspace="0" hspace="0" allowtransparency="true" scrolling="no"></iframe>');d!=null&&c.write("</div>")}}else a.google_ad_output=="textlink"&&c.write("<"+e+' language="JavaScript1.1" src='+L(b)+"></"+e+
">")}function Aa(a){for(var c in v)a[c]=null;for(var c in w){if(c=="google_correlator")continue;a[c]=null}}function Ba(a){if(a.google_ad_format)return a.google_ad_format.indexOf("_0ads")>0;return a.google_ad_output!="html"&&a.google_num_radlinks>0}function S(a){return a&&a.indexOf("_sdo")!=-1}function Ca(a){var c=null,b=window,d=document,e=new Date,g=e.getTime(),k=b.google_ad_format,l=va(b,0.0010);if(b.google_cpa_choice!=c){b.google_ad_url=l+"/cpa/ads?";b.google_ad_url+="client="+escape(R(b.google_ad_client));
b.google_ad_region="_google_cpa_region_";N("google_cpa_choice");if(typeof d.characterSet!="undefined")O("oe",d.characterSet);else typeof d.charset!="undefined"&&O("oe",d.charset)}else if(S(k)){b.google_ad_url=l+"/pagead/sdo?";b.google_ad_url+="client="+escape(ya(b.google_ad_client))}else{b.google_ad_url=l+"/pagead/ads?";b.google_ad_url+="client="+escape(R(b.google_ad_client))}N("google_ad_host");N("google_ad_host_tier_id");var i=b.google_num_slots_by_client,p=b.google_num_slots_by_channel,o=b.google_prev_ad_formats_by_region,
q=b.google_prev_ad_slotnames_by_region;if(b.google_ad_region==c&&b.google_ad_section!=c)b.google_ad_region=b.google_ad_section;var m=b.google_ad_region==c?"":b.google_ad_region;if(S(k)){b.google_num_sdo_slots=b.google_num_sdo_slots?b.google_num_sdo_slots+1:1;if(b.google_num_sdo_slots>4)return false}else if(Ba(b)){b.google_num_0ad_slots=b.google_num_0ad_slots?b.google_num_0ad_slots+1:1;if(b.google_num_0ad_slots>3)return false}else if(b.google_cpa_choice==c){b.google_num_ad_slots=b.google_num_ad_slots?
b.google_num_ad_slots+1:1;if(b.google_num_slots_to_rotate){o[m]=c;q[m]=c;if(b.google_num_slot_to_show==c)b.google_num_slot_to_show=g%b.google_num_slots_to_rotate+1;if(b.google_num_slot_to_show!=b.google_num_ad_slots)return false}else if(b.google_num_ad_slots>6&&m=="")return false}M("dt",e.getTime());N("google_language");b.google_country?N("google_country"):N("google_gl");N("google_region");P("google_city");P("google_hints");N("google_safe");N("google_encoding");N("google_last_modified_time");P("google_alternate_ad_url");
N("google_alternate_color");N("google_skip");N("google_targeting");var t=b.google_ad_client;if(i[t])i[t]+=1;else{i[t]=1;i.length+=1}if(o[m])if(!S(k)){O("prev_fmts",o[m].toLowerCase());i.length>1&&M("slot",i[t])}q[m]&&O("prev_slotnames",q[m].toLowerCase());if(k&&!b.google_ad_slot){O("format",k.toLowerCase());S(k)||(o[m]=o[m]?o[m]+","+k:k)}if(b.google_ad_slot)q[m]=q[m]?q[m]+","+b.google_ad_slot:b.google_ad_slot;N("google_max_num_ads");M("output",b.google_ad_output);N("google_adtest");N("google_ad_callback");
N("google_ad_slot");P("google_correlator");if(b.google_ad_channel){P("google_ad_channel");var T="",U=b.google_ad_channel.split(/[+, ]/);for(var I=0;I<U.length;I++){var J=U[I];if(p[J])T+=J+"+";else p[J]=1}O("pv_ch",T)}if(b.google_ad_host_channel){P("google_ad_host_channel");var Ea=Da(b.google_ad_host_channel,b.google_viewed_host_channels);O("pv_h_ch",Ea)}b.google_enable_first_party_cookie&&O("cookie",b._GA_googleCookieHelper.j());P("google_page_url");Q("google_color_bg",g);Q("google_color_text",g);
Q("google_color_link",g);Q("google_color_url",g);Q("google_color_border",g);Q("google_color_line",g);b.google_reuse_colors?M("reuse_colors",1):M("reuse_colors",0);N("google_kw_type");P("google_kw");P("google_contents");N("google_num_radlinks");N("google_max_radlink_len");N("google_rl_filtering");N("google_rl_mode");N("google_rt");P("google_rl_dest_url");N("google_num_radlinks_per_unit");N("google_ad_type");N("google_image_size");N("google_ad_region");N("google_feedback");P("google_referrer_url");
P("google_page_location");M("frm",b.google_iframing);N("google_bid");N("google_ctr_threshold");N("google_cust_age");N("google_cust_gender");N("google_cust_interests");N("google_cust_id");N("google_cust_job");N("google_cust_u_url");N("google_cust_l");N("google_cust_lh");N("google_cust_ch");N("google_ed");N("google_video_doc_id");N("google_video_product_type");P("google_ui_features");P("google_only_ads_with_video");P("google_disable_video_autoplay");a&&O("ff",ta(a));if(b.top.location==d.location&&d.body){var V=
d.body.scrollHeight,W=d.body.clientHeight;W&&V&&O("cc",Math.round(W*100/V))}n();M("ga_vid",b.gaGlobal.vid);M("ga_sid",b.gaGlobal.sid);M("ga_hid",b.gaGlobal.hid);M("ga_fc",b.gaGlobal.from_cookie);P("google_analytics_uacct");N("google_ad_override");N("google_flash_version");wa(b,e);return true}function Da(a,c){var b=a.split("|"),d=-1,e=[];for(var g=0;g<b.length;g++){var k=b[g].split(/[+, ]/);c[g]||(c[g]={});var l="";for(var i=0;i<k.length;i++){var p=k[i];if(c[g][p])l+="+"+p;else c[g][p]=1}l=l.slice(1);
e[g]=l;if(l!="")d=g}var o="";if(d>-1){for(var g=0;g<d;g++)o+=e[g]+"|";o+=e[d]}return o}function X(){var a=window,c=document;xa(a);var b;if(Math.random()<0.01){var d="google_temp_span";if(!G(d)){c.write("<span id="+d+"></span>");b=G(d)}}var e=Ca(b);b&&(b&&b.parentNode?b.parentNode.removeChild(b):null);if(!e)return;za(a,c,a.google_ad_url,null);Aa(a)}function Fa(){X();return true}function Ga(a,c){var b=c.documentElement;if(a.top.location==c.location)return false;if(a.google_ad_width&&a.google_ad_height){var d=
1,e=1;if(a.innerHeight){d=a.innerWidth;e=a.innerHeight}else if(b&&b.clientHeight){d=b.clientWidth;e=b.clientHeight}else if(c.body){d=c.body.clientWidth;e=c.body.clientHeight}if(e>2*a.google_ad_height||d>2*a.google_ad_width)return false}return true}function Ha(a){var c=window,b=null,d=c.onerror;c.onerror=a;if(c.google_ad_frameborder==b)c.google_ad_frameborder=0;if(c.google_ad_output==b)c.google_ad_output="html";if(S(c.google_ad_format)){var e=c.google_ad_format.match(/^(\d+)x(\d+)_.*/);if(e){c.google_ad_width=
parseInt(e[1],10);c.google_ad_height=parseInt(e[2],10);c.google_ad_output="html"}}if(c.google_ad_format==b&&c.google_ad_output=="html")c.google_ad_format=c.google_ad_width+"x"+c.google_ad_height;Ia(c,document);if(c.google_num_slots_by_channel==b)c.google_num_slots_by_channel=[];if(c.google_viewed_host_channels==b)c.google_viewed_host_channels=[];if(c.google_num_slots_by_client==b)c.google_num_slots_by_client=[];if(c.google_prev_ad_formats_by_region==b)c.google_prev_ad_formats_by_region=[];if(c.google_prev_ad_slotnames_by_region==
b)c.google_prev_ad_slotnames_by_region=[];if(c.google_correlator==b)c.google_correlator=(new Date).getTime();if(c.google_adslot_loaded==b)c.google_adslot_loaded={};if(c.google_adContentsBySlot==b)c.google_adContentsBySlot={};if(c.google_flash_version==b)c.google_flash_version=ca();c.google_blocking_test==b&&Ja(c);c.onerror=d}function Ja(a){a.google_blocking_test=1;if(Math.random()<0.0010){var c="script",b=(new Date).getTime(),d=new Array("<",c,' type="text/javascript">',"var i=new Image();",'i.src="http://googleads.g.doubleclick.net/',
"pagead/gen_204?id=js_blocking&t=d&dt=",b,'";',"var j=new Image();",'j.src="http://pagead2.googlesyndication.com/',"pagead/gen_204?id=js_blocking&t=p&dt=",b,'";',"</",c,">");document.write(d.join(""))}}function da(a){if(a in Y)return Y[a];return Y[a]=navigator.userAgent.toLowerCase().indexOf(a)!=-1}var Y={};function Ka(a){var c={},b=a.split("?"),d=b[b.length-1].split("&");for(var e=0;e<d.length;e++){var g=d[e].split("=");if(g[0])try{c[g[0].toLowerCase()]=g.length>1?window.decodeURIComponent?decodeURIComponent(g[1].replace(/\+/g,
" ")):unescape(g[1]):""}catch(k){}}return c}function La(){var a=window,c=Ka(document.URL);if(c.google_ad_override){a.google_ad_override=c.google_ad_override;a.google_adtest="on"}}function Ma(a,c){for(var b in c)a["google_"+b]=c[b]}function Z(a,c){if(!c)return a.location;return a.referrer}function Na(a,c){if(!c&&a.google_referrer_url==null)return"0";else if(c&&a.google_referrer_url==null)return"1";else if(!c&&a.google_referrer_url!=null)return"2";else if(c&&a.google_referrer_url!=null)return"3";return"4"}
function Oa(a,c,b,d){a.page_url=Z(b,d);a.page_location=null}function Pa(a,c,b,d){a.page_url=c.google_page_url;a.page_location=Z(b,d)||"EMPTY"}function Qa(a,c){var b={},d=Ga(a,c);b.iframing=Na(a,d);!!a.google_page_url?Pa(b,a,c,d):Oa(b,a,c,d);b.last_modified_time=c.location==b.page_url?Date.parse(c.lastModified)/1000:null;b.referrer_url=d?a.google_referrer_url:a.google_page_url&&a.google_referrer_url?a.google_referrer_url:c.referrer;return b}function Ra(a){var c={},b=a.URL.substring(a.URL.lastIndexOf("http"));
c.iframing=null;c.page_url=b;c.page_location=a.location;c.last_modified_time=null;c.referrer_url=b;return c}function Ia(a,c){var b;b=a.google_page_url==null&&$[c.domain]?Ra(c):Qa(a,c);Ma(a,b)}var $={};$["ad.yieldmanager.com"]=true;La();Ha(Fa);X();
})()

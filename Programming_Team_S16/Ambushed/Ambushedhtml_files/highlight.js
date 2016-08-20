var hljs=new function(){function l(o){return o.replace(/&/gm,"&amp;").replace(/</gm,"&lt;").replace(/>/gm,"&gt;")}function b(p){for(var o=p.firstChild;o;o=o.nextSibling){if(o.nodeName=="CODE"){return o}if(!(o.nodeType==3&&o.nodeValue.match(/\s+/))){break}}}function h(p,o){return Array.prototype.map.call(p.childNodes,function(q){if(q.nodeType==3){return o?q.nodeValue.replace(/\n/g,""):q.nodeValue}if(q.nodeName=="BR"){return"\n"}return h(q,o)}).join("")}function a(q){var p=(q.className+" "+(q.parentNode?q.parentNode.className:"")).split(/\s+/);p=p.map(function(r){return r.replace(/^language-/,"")});for(var o=0;o<p.length;o++){if(e[p[o]]||p[o]=="no-highlight"){return p[o]}}}function c(q){var o=[];(function p(r,s){for(var t=r.firstChild;t;t=t.nextSibling){if(t.nodeType==3){s+=t.nodeValue.length}else{if(t.nodeName=="BR"){s+=1}else{if(t.nodeType==1){o.push({event:"start",offset:s,node:t});s=p(t,s);o.push({event:"stop",offset:s,node:t})}}}}return s})(q,0);return o}function j(x,v,w){var p=0;var y="";var r=[];function t(){if(x.length&&v.length){if(x[0].offset!=v[0].offset){return(x[0].offset<v[0].offset)?x:v}else{return v[0].event=="start"?x:v}}else{return x.length?x:v}}function s(A){function z(B){return" "+B.nodeName+'="'+l(B.value)+'"'}return"<"+A.nodeName+Array.prototype.map.call(A.attributes,z).join("")+">"}while(x.length||v.length){var u=t().splice(0,1)[0];y+=l(w.substr(p,u.offset-p));p=u.offset;if(u.event=="start"){y+=s(u.node);r.push(u.node)}else{if(u.event=="stop"){var o,q=r.length;do{q--;o=r[q];y+=("</"+o.nodeName.toLowerCase()+">")}while(o!=u.node);r.splice(q,1);while(q<r.length){y+=s(r[q]);q++}}}}return y+l(w.substr(p))}function f(r){function o(s){return(s&&s.source)||s}function p(t,s){return RegExp(o(t),"m"+(r.cI?"i":"")+(s?"g":""))}function q(z,x){if(z.compiled){return}z.compiled=true;var u=[];if(z.k){var s={};function A(B,t){t.split(" ").forEach(function(C){var D=C.split("|");s[D[0]]=[B,D[1]?Number(D[1]):1];u.push(D[0])})}z.lR=p(z.l||hljs.IR+"(?!\\.)",true);if(typeof z.k=="string"){A("keyword",z.k)}else{for(var y in z.k){if(!z.k.hasOwnProperty(y)){continue}A(y,z.k[y])}}z.k=s}if(x){if(z.bWK){z.b="\\b("+u.join("|")+")\\b(?!\\.)\\s*"}z.bR=p(z.b?z.b:"\\B|\\b");if(!z.e&&!z.eW){z.e="\\B|\\b"}if(z.e){z.eR=p(z.e)}z.tE=o(z.e)||"";if(z.eW&&x.tE){z.tE+=(z.e?"|":"")+x.tE}}if(z.i){z.iR=p(z.i)}if(z.r===undefined){z.r=1}if(!z.c){z.c=[]}for(var w=0;w<z.c.length;w++){if(z.c[w]=="self"){z.c[w]=z}q(z.c[w],z)}if(z.starts){q(z.starts,x)}var v=[];for(var w=0;w<z.c.length;w++){v.push(o(z.c[w].b))}if(z.tE){v.push(o(z.tE))}if(z.i){v.push(o(z.i))}z.t=v.length?p(v.join("|"),true):{exec:function(t){return null}}}q(r)}function d(E,F,C){function o(r,N){for(var M=0;M<N.c.length;M++){var L=N.c[M].bR.exec(r);if(L&&L.index==0){return N.c[M]}}}function s(L,r){if(L.e&&L.eR.test(r)){return L}if(L.eW){return s(L.parent,r)}}function t(r,L){return !C&&L.i&&L.iR.test(r)}function y(M,r){var L=G.cI?r[0].toLowerCase():r[0];return M.k.hasOwnProperty(L)&&M.k[L]}function H(){var L=l(w);if(!A.k){return L}var r="";var O=0;A.lR.lastIndex=0;var M=A.lR.exec(L);while(M){r+=L.substr(O,M.index-O);var N=y(A,M);if(N){v+=N[1];r+='<span class="'+N[0]+'">'+M[0]+"</span>"}else{r+=M[0]}O=A.lR.lastIndex;M=A.lR.exec(L)}return r+L.substr(O)}function z(){if(A.sL&&!e[A.sL]){return l(w)}var r=A.sL?d(A.sL,w):g(w);if(A.r>0){v+=r.keyword_count;B+=r.r}return'<span class="'+r.language+'">'+r.value+"</span>"}function K(){return A.sL!==undefined?z():H()}function J(M,r){var L=M.cN?'<span class="'+M.cN+'">':"";if(M.rB){x+=L;w=""}else{if(M.eB){x+=l(r)+L;w=""}else{x+=L;w=r}}A=Object.create(M,{parent:{value:A}})}function D(L,r){w+=L;if(r===undefined){x+=K();return 0}var N=o(r,A);if(N){x+=K();J(N,r);return N.rB?0:r.length}var O=s(A,r);if(O){var M=A;if(!(M.rE||M.eE)){w+=r}x+=K();do{if(A.cN){x+="</span>"}B+=A.r;A=A.parent}while(A!=O.parent);if(M.eE){x+=l(r)}w="";if(O.starts){J(O.starts,"")}return M.rE?0:r.length}if(t(r,A)){throw new Error('Illegal lexem "'+r+'" for mode "'+(A.cN||"<unnamed>")+'"')}w+=r;return r.length||1}var G=e[E];f(G);var A=G;var w="";var B=0;var v=0;var x="";try{var u,q,p=0;while(true){A.t.lastIndex=p;u=A.t.exec(F);if(!u){break}q=D(F.substr(p,u.index-p),u[0]);p=u.index+q}D(F.substr(p));return{r:B,keyword_count:v,value:x,language:E}}catch(I){if(I.message.indexOf("Illegal")!=-1){return{r:0,keyword_count:0,value:l(F)}}else{throw I}}}function g(s){var o={keyword_count:0,r:0,value:l(s)};var q=o;for(var p in e){if(!e.hasOwnProperty(p)){continue}var r=d(p,s,false);r.language=p;if(r.keyword_count+r.r>q.keyword_count+q.r){q=r}if(r.keyword_count+r.r>o.keyword_count+o.r){q=o;o=r}}if(q.language){o.second_best=q}return o}function i(q,p,o){if(p){q=q.replace(/^((<[^>]+>|\t)+)/gm,function(r,v,u,t){return v.replace(/\t/g,p)})}if(o){q=q.replace(/\n/g,"<br>")}return q}function m(s,v,q){var x=h(s,q);var u=a(s);if(u=="no-highlight"){return}var z=u?d(u,x,true):g(x);u=z.language;var o=c(s);if(o.length){var r=document.createElement("pre");r.innerHTML=z.value;z.value=j(o,c(r),x)}z.value=i(z.value,v,q);var t=s.className;if(!t.match("(\\s|^)(language-)?"+u+"(\\s|$)")){t=t?(t+" "+u):u}if(t.indexOf("lineNumbers")!=-1){var p=document.createElement("pre");p.innerHTML=z.value;var w=document.createElement("pre");var y=l(x).replace(/^/gm,'<span class="line"></span>');w.innerHTML=y;z.value=j(c(w),c(p),x)}s.innerHTML=z.value;s.className=t;s.result={language:u,kw:z.keyword_count,re:z.r};if(z.second_best){s.second_best={language:z.second_best.language,kw:z.second_best.keyword_count,re:z.second_best.r}}}function n(){if(n.called){return}n.called=true;Array.prototype.map.call(document.getElementsByTagName("pre"),b).filter(Boolean).forEach(function(o){m(o,hljs.tabReplace,hljs.useBR)})}function k(){window.addEventListener("DOMContentLoaded",n,false);window.addEventListener("load",n,false)}var e={};this.LANGUAGES=e;this.highlight=d;this.highlightAuto=g;this.fixMarkup=i;this.highlightBlock=m;this.initHighlighting=n;this.initHighlightingOnLoad=k;this.IR="[a-zA-Z][a-zA-Z0-9_]*";this.UIR="[a-zA-Z_][a-zA-Z0-9_]*";this.NR="\\b\\d+(\\.\\d+)?";this.CNR="(\\b0[xX][a-fA-F0-9]+|(\\b\\d+(\\.\\d*)?|\\.\\d+)([eE][-+]?\\d+)?)";this.BNR="\\b(0b[01]+)";this.RSR="!|!=|!==|%|%=|&|&&|&=|\\*|\\*=|\\+|\\+=|,|\\.|-|-=|/|/=|:|;|<<|<<=|<=|<|===|==|=|>>>=|>>=|>=|>>>|>>|>|\\?|\\[|\\{|\\(|\\^|\\^=|\\||\\|=|\\|\\||~";this.BE={b:"\\\\[\\s\\S]",r:0};this.ASM={cN:"string",b:"'",e:"'",i:"\\n",c:[this.BE],r:0};this.QSM={cN:"string",b:'"',e:'"',i:"\\n",c:[this.BE],r:0};this.CLCM={cN:"comment",b:"//",e:"$"};this.CBLCLM={cN:"comment",b:"/\\*",e:"\\*/"};this.HCM={cN:"comment",b:"#",e:"$"};this.NM={cN:"number",b:this.NR,r:0};this.CNM={cN:"number",b:this.CNR,r:0};this.BNM={cN:"number",b:this.BNR,r:0};this.REGEXP_MODE={cN:"regexp",b:/\//,e:/\/[gim]*/,i:/\n/,c:[this.BE,{b:/\[/,e:/\]/,r:0,c:[this.BE]}]};this.inherit=function(q,r){var o={};for(var p in q){o[p]=q[p]}if(r){for(var p in r){o[p]=r[p]}}return o}}();hljs.LANGUAGES.scala=function(a){var c={cN:"annotation",b:"@[A-Za-z]+"};var b={cN:"string",b:'u?r?"""',e:'"""',r:10};return{k:"type yield lazy override def with val var false true sealed abstract private trait object null if for while throw finally protected extends import final return else break new catch super class case package default try this match continue throws",c:[{cN:"javadoc",b:"/\\*\\*",e:"\\*/",c:[{cN:"javadoctag",b:"@[A-Za-z]+"}],r:10},a.CLCM,a.CBLCLM,a.ASM,a.QSM,b,{cN:"class",b:"((case )?class |object |trait )",e:"({|$)",i:":",k:"case class trait object",c:[{bWK:true,k:"extends with",r:10},{cN:"title",b:a.UIR},{cN:"params",b:"\\(",e:"\\)",c:[a.ASM,a.QSM,b,c]}]},a.CNM,c]}}(hljs);hljs.LANGUAGES.cpp=function(a){var b={keyword:"false int float while private char catch export virtual operator sizeof dynamic_cast|10 typedef const_cast|10 const struct for static_cast|10 union namespace unsigned long throw volatile static protected bool template mutable if public friend do return goto auto void enum else break new extern using true class asm case typeid short reinterpret_cast|10 default double register explicit signed typename try this switch continue wchar_t inline delete alignof char16_t char32_t constexpr decltype noexcept nullptr static_assert thread_local restrict _Bool complex",built_in:"std string cin cout cerr clog stringstream istringstream ostringstream auto_ptr deque list queue stack vector map set bitset multiset multimap unordered_set unordered_map unordered_multiset unordered_multimap array shared_ptr"};return{k:b,i:"</",c:[a.CLCM,a.CBLCLM,a.QSM,{cN:"string",b:"'\\\\?.",e:"'",i:"."},{cN:"number",b:"\\b(\\d+(\\.\\d*)?|\\.\\d+)(u|U|l|L|ul|UL|f|F)"},a.CNM,{cN:"preprocessor",b:"#",e:"$",c:[{b:"<",e:">",i:"\\n"},a.CLCM]},{cN:"stl_container",b:"\\b(deque|list|queue|stack|vector|map|set|bitset|multiset|multimap|unordered_map|unordered_set|unordered_multiset|unordered_multimap|array)\\s*<",e:">",k:b,r:10,c:["self"]}]}}(hljs);hljs.LANGUAGES.go=function(a){var b={keyword:"break default func interface select case map struct chan else goto package switch const fallthrough if range type continue for import return var go defer",constant:"true false iota nil",typename:"bool byte complex64 complex128 float32 float64 int8 int16 int32 int64 string uint8 uint16 uint32 uint64 int uint uintptr rune",built_in:"append cap close complex copy imag len make new panic print println real recover delete"};return{k:b,i:"</",c:[a.CLCM,a.CBLCLM,a.QSM,{cN:"string",b:"'",e:"[^\\\\]'",r:0},{cN:"string",b:"`",e:"`"},{cN:"number",b:"[^a-zA-Z_0-9](\\-|\\+)?\\d+(\\.\\d+|\\/\\d+)?((d|e|f|l|s)(\\+|\\-)?\\d+)?",r:0},a.CNM]}}(hljs);hljs.LANGUAGES.java=function(a){return{k:"false synchronized int abstract float private char boolean static null if const for true while long throw strictfp finally protected import native final return void enum else break transient new catch instanceof byte super volatile case assert short package default double public try this switch continue throws",c:[{cN:"javadoc",b:"/\\*\\*",e:"\\*/",c:[{cN:"javadoctag",b:"(^|\\s)@[A-Za-z]+"}],r:10},a.CLCM,a.CBLCLM,a.ASM,a.QSM,{cN:"class",bWK:true,e:"{",k:"class interface",eE:true,i:":",c:[{bWK:true,k:"extends implements",r:10},{cN:"title",b:a.UIR}]},a.CNM,{cN:"annotation",b:"@[A-Za-z]+"}]}}(hljs);hljs.LANGUAGES.python=function(a){var f={cN:"prompt",b:/^(>>>|\.\.\.) /};var c=[{cN:"string",b:/(u|b)?r?'''/,e:/'''/,c:[f],r:10},{cN:"string",b:/(u|b)?r?"""/,e:/"""/,c:[f],r:10},{cN:"string",b:/(u|r|ur)'/,e:/'/,c:[a.BE],r:10},{cN:"string",b:/(u|r|ur)"/,e:/"/,c:[a.BE],r:10},{cN:"string",b:/(b|br)'/,e:/'/,c:[a.BE]},{cN:"string",b:/(b|br)"/,e:/"/,c:[a.BE]}].concat([a.ASM,a.QSM]);var e={cN:"title",b:a.UIR};var d={cN:"params",b:/\(/,e:/\)/,c:["self",a.CNM,f].concat(c)};var b={bWK:true,e:/:/,i:/[${=;\n]/,c:[e,d],r:10};return{k:{keyword:"and elif is global as in if from raise for except finally print import pass return exec else break not with class assert yield try while continue del or def lambda nonlocal|10",built_in:"None True False Ellipsis NotImplemented"},i:/(<\/|->|\?)/,c:c.concat([f,a.HCM,a.inherit(b,{cN:"function",k:"def"}),a.inherit(b,{cN:"class",k:"class"}),a.CNM,{cN:"decorator",b:/@/,e:/$/},{b:/\b(print|exec)\(/}])}}(hljs);
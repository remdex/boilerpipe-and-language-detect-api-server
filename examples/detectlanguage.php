<?php

$text = 'Be abejonės, tai buvo labai seniai, gal datą ir netiksliai pasakiau. Aš esu vienas iš krikščionių demokratų partijos signatarų, vienas iš įkūrėjų. <...> Norėjau pasakyti neapšmeiždamas krikščionių demokratų, bet pasakyti, kad tai daroma beveik visose partijose. Kitas dalykas, šiandien, partijos gal ir neturi juodųjų technologijų, bet pavyzdžiui per agentūras viešinami ministerijų darbai, ministerijoms vadovauja ministrai. Paviešina kažkiek ministerijų darbus, o už pusę paviešina partijos gerus darbus, patį ministrą. Šiandien yra tokios technologijos, kad įrodyti beveik neįmanoma. Visi žino, kad tas yra daroma.';

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, "http://127.0.0.1:8080/detectlanguage");
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_TIMEOUT, 60);            
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $text);
curl_setopt($ch, CURLOPT_HTTPHEADER,array("Expect:")); // Because first is returned HTTP 100 header status.
$content = curl_exec($ch);

echo $content;

// {"result":"[lt:0.9999967878844577]","error":"false"}
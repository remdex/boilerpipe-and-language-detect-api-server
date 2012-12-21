<?php

$text = file_get_contents('http://remdex.info/High-performance-photo-gallery-95a.html');

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, "http://127.0.0.1:8080/extractcontent");
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_TIMEOUT, 60);            
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $text);
curl_setopt($ch, CURLOPT_HTTPHEADER,array("Expect:")); // Because first is returned HTTP 100 header status.
$content = curl_exec($ch);

echo $content;

// {"result":"Benchmark was done under normal server working condition.\nBenchmark of last uploads page. Totaly cached page.\n[root@remdex devhppg]# ab -c 100 -n 500 http://animeonly.org/gallery/lastuploads/ This is ApacheBench, Version 2.0.40-dev <$Revision: 1.146 $> apache-2.0 Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/ Copyright 2006 The Apache Software Foundation, http://www.apache.org/  Benchmarking animeonly.org (be patient) Completed 100 requests Completed 200 requests Completed 300 requests Completed 400 requests Finished 500 requests   Server Software:        lighttpd/1.4.22 Server Hostname:        animeonly.org Server Port:            80  Document Path:          /gallery/lastuploads/ Document Length:        26391 bytes  Concurrency Level:      100 Time taken for tests:   2.914846 seconds Complete requests:      500 Failed requests:        0 Write errors:           0 Total transferred:      13363046 bytes HTML transferred:       13195500 bytes Requests per second:    171.54 [#/sec] (mean) Time per request:       582.969 [ms] (mean) Time per request:       5.830 [ms] (mean, across all concurrent requests) Transfer rate:          4476.74 [Kbytes/sec] received  Connection Times (ms)               min  mean[+/-sd] median   max Connect:        0    0   1.3      0       5 Processing:   159  532 278.3    471    1856 Waiting:      157  532 278.2    471    1855 Total:        160  533 278.2    471    1856  Percentage of the requests served within a certain time (ms)   50%    471   66%    554   75%    584   80%    608   90%    668   95%   1364   98%   1751   99%   1793  100%   1856 (longest request)\nSource code\nEarly  verson of source code can be found. It's not fo production use, because  a lot of part need to change to be configurable, need install and so  on. But tu get picture of software it quet usefull. I'm planning during  one month preprate install for gallery and fix remaining hardcoded  things.\n","error":"false"}
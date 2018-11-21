# scalaPlayJsonCirce
Scala Play app using Circe and play-json

## Benchmarks
```
ab -n 100000 -c 10 http://localhost:9000/
This is ApacheBench, Version 2.3 <$Revision: 1807734 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Server Software:        
Server Hostname:        localhost
Server Port:            9000

Document Path:          /
Document Length:        67 bytes

Concurrency Level:      10
Time taken for tests:   10.272 seconds
Complete requests:      100000
Failed requests:        0
Total transferred:      43300000 bytes
HTML transferred:       6700000 bytes
Requests per second:    9735.44 [#/sec] (mean)
Time per request:       1.027 [ms] (mean)
Time per request:       0.103 [ms] (mean, across all concurrent requests)
Transfer rate:          4116.65 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.0      0       1
Processing:     0    1   0.3      1      12
Waiting:        0    1   0.3      1      11
Total:          0    1   0.3      1      12
```

```
ab -n 100000 -c 10 http://localhost:9000/c

Server Software:        
Server Hostname:        localhost
Server Port:            9000

Document Path:          /c
Document Length:        67 bytes

Concurrency Level:      10
Time taken for tests:   10.195 seconds
Complete requests:      100000
Failed requests:        0
Total transferred:      43300000 bytes
HTML transferred:       6700000 bytes
Requests per second:    9808.40 [#/sec] (mean)
Time per request:       1.020 [ms] (mean)
Time per request:       0.102 [ms] (mean, across all concurrent requests)
Transfer rate:          4147.50 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.0      0       2
Processing:     0    1   0.3      1      13
Waiting:        0    1   0.3      1      12
Total:          0    1   0.3      1      13
```

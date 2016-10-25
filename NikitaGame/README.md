
# Common mistakes

Closures are powerful feature in JavaScript. However, if you misuse or overuse it causes wrong results and memory leak. Here I am going to show some common mistakes in reality.

### In `for` loop

Let's supposed that you want to put 5 buttons and show button id when it is clicked.

Sample input
```
3
3
3 3 3
4
2 2 2 2
7
4 1 0 1 1 0 1
```

Sample output
```
0
2
3
```

TestCase-1
```
1
8
2 1 1 2 1 1 4 4
```
Output
```
4
```

TestCase-2
```
1
3
2 2 4
```
Output
```
2
```


TestCase-3
```
1
3
4 2 2
```
Output
```
2
```

TestCase-4
```

1
103
4096 4096 1024 256 256 128 128 128 128 512 512 512 512 256 256 512 512 128 32 32 32 32 128 128 1024 1024 2048 512 512 1024 2048 2048 1024 512 512 2048 2048 2048 16384 16384 2048 256 128 128 512 256 256 512 2048 1024 1024 512 512 1024 1024 1024 2048 512 512 1024 4096 4096 4096 2048 2048 4096 2048 2048 2048 1024 512 256 16 16 32 64 128 2048 512 512 512 512 8192 8192 32768 32768 65536 16384 8192 4096 4096 16384 16384 32768 8192 8192 16384 65536 16384 16384 16384 8192 8192
```
Output
```
15
```




Someone can make the code using jQuery to add click event handler.

```
var $buttons = $("button");
var len = $buttons.length;

for(var i = 0; i < len; i++) {
  $($buttons[i]).click(function() {
    // put your logic
    alert('Script1: ' + i);
  });
}
```

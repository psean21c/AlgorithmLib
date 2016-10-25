
# Common mistakes

Closures are powerful feature in JavaScript. However, if you misuse or overuse it causes wrong results and memory leak. Here I am going to show some common mistakes in reality.

### In `for` loop

Let's supposed that you want to put 5 buttons and show button id when it is clicked.

HTML code
```
    <button id="btn-1">Button - 1</button>
    <button id="btn-2">Button - 2</button>
    <button id="btn-3">Button - 3</button>
    <button id="btn-4">Button - 4</button>
    <button id="btn-5">Button - 5</button>
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

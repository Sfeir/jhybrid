// Deeply inspired from the Chrome Apps Tutorial
var Model;

(function(exports) {

    var nextId = 1;

    Model = function() {
        this.content = {};
        this.listeners = [];
    }

    Model.prototype.notifyListeners = function(changeType, id) {
        var model = this;
        this.listeners.forEach(function(listener) {
            listener(model, changeType, id);
        });
    }

    Model.prototype.clear = function() {
        this.content = {};
        this.notifyListeners('removed');
    }

    Model.prototype.add = function(text) {
        var id = nextId++;
        this.content[id]={'id': id, 'text': text};
        this.notifyListeners('added', id);
    }

    Model.prototype.addListener = function(listener) {
        this.listeners.push(listener);
    }

    exports.Model = Model;

})(window);


// This function is called immediately after the CalcEngine Library is loaded.

var calcEngineReady = function(calcEngine){
    var model = new Model();
    var form = document.querySelector('form');
    var clear = document.getElementById('clear');
    var list = document.getElementById('list');
    var template = document.querySelector('#templates > [data-name="list"]');

    /**
     * When the form is submitted, we need to add a new expression and clear the input
     **/
    form.addEventListener('submit', function(e) {
        var textEl = e.target.querySelector('input[type="text"]');
        try {
            var value = textEl.value;
            var result = calcEngine.evaluate(value);
            model.add(value + " = " + result);
            textEl.value=null;
            e.preventDefault();
        }
        catch (e){
            alert("The expression : '" + value + "' is unparsable." )
            console.error(e);
        }
    });


    /**
     * A simple handler for the clear link
     **/
    clear.addEventListener('click', function(e) {
        model.clear();
        e.preventDefault();
    });


    /**
     * Listen to changes in the model and trigger the appropriate changes in the view
     **/
    model.addListener(function(model, changeType, param) {
        if ( changeType === 'removed') {
            redrawUI(model);
        } else if ( changeType === 'added' ) {
            drawList(model.content[param], list);
        }
    });

    /**
     * Clean the current expressions list and add elements again
     **/
    var redrawUI = function(model) {
        list.innerHTML='';
        for (var id in model.content) {
            drawList(model.content[id], list);
        }
    };

    /**
     * Deep clone a template node, set its ID and add it to the DOM container.
     **/
    var drawList = function(expression, container) {
        var el = template.cloneNode(true);
        el.setAttribute('data-id', expression.id);
        container.appendChild(el);
        update(expression);
    }


    /**
     * Find the element corresponding to the given Expression model object and update its
     * state and description from the model.
     */
    var update = function(model) {
        var exprElement = list.querySelector('li[data-id="'+model.id+'"]');
        if (exprElement) {
            var desc = exprElement.querySelector('span');
            desc.innerText = model.text;
        }
    }
}


/**
 * Created by a on 8/1/2018.
 */
Vue.component('message-row', {
    props: ['message'],
    template: '<div><i>({{message.id}})</i> {{message.text}} </div>'
});

Vue.component('messages-list', {
    props: ['messages'],
    template: '<div><message-row v-for="message in messages" :message="message" /></div>'
});

var app = new Vue({
    el: '#app',
    template: '<messages-list :messages="messages"/>',
    data: {
        messages: [
            {id: '1', text: '001'},
            {id: '2', text: '002'},
            {id: '3', text: '003'},
        ]
    }
});


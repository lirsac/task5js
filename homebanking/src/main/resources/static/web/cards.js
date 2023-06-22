new Vue({
    el: '#app',
    data: {
        isLoading: true,
        client: {
            cards: []
        }
    },
    mounted() {
        this.fetchClientData();
    },
    methods: {
        fetchClientData() {
            axios.get('/api/clients/1')
                .then(response => {
                    this.client = response.data;
                    this.isLoading = false;
                })
                .catch(error => {
                    console.log(error);
                    this.isLoading = false;
                });
        }
    },
    computed: {
        creditCards() {
            return this.client.cards.filter(card => card.type === 'CREDIT');
        },
        debitCards() {
            return this.client.cards.filter(card => card.type === 'DEBIT');
        }
    }
});

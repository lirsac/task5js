const app = new Vue({
  el: '#app',
  data: {
    client: {},
    accounts: []
  },
  mounted() {
    this.fetchClientData();
  },
  methods: {
    fetchClientData() {
      axios
        .get('/api/clients/1')
        .then(response => {
          this.client = response.data;
          this.accounts = response.data.accounts.sort((a, b) => a.number.localeCompare(b.number));
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
});

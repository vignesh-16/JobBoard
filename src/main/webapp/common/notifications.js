function showNotification(message) {
    let notification = document.getElementById('notification-container');
    let notificationMessage = document.getElementById('notification-message');
    notificationMessage.innerText = message;
    notification.classList.remove('hidden');
    setTimeout(function() {
      closeNotification();
    }, 5000); // Close the notification after 5 seconds
  }
  
  function closeNotification() {
    let notification = document.getElementById('notification-container');
    notification.classList.add('hidden');
  }
  